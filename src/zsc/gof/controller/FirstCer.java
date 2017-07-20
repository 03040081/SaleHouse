package zsc.gof.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.CityBiz;
import zsc.gof.biz.HouseBiz;
import zsc.gof.biz.HousetypeBiz;
import zsc.gof.biz.PremiseBiz;
import zsc.gof.biz.PremisetypeBiz;
import zsc.gof.biz.RegionBiz;
import zsc.gof.entity.City;
import zsc.gof.entity.House;
import zsc.gof.entity.Housetype;
import zsc.gof.entity.PageModel;
import zsc.gof.entity.Premises;
import zsc.gof.entity.Premisetype;
import zsc.gof.entity.Region;

@Controller
public class FirstCer {

	@Autowired
	PremiseBiz premiseBiz;
	@Autowired
	HttpServletRequest request;
	@Autowired
	RegionBiz regBiz;
	@Autowired
	PremisetypeBiz pretyBiz;
	@Autowired
	HousetypeBiz houtyBiz;
	@Autowired
	CityBiz cityBiz;
	@Autowired
	HouseBiz houseBiz;

	/*
	 * 从首页输入模糊查询 跳转至列表找房子
	 */
	@RequestMapping("/Search")
	public ModelAndView search(@RequestParam("keyword") String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		PageModel<Premises> listPre = new PageModel<Premises>();

		HttpSession session = request.getSession();
		int cityId = ((City)session.getAttribute("currCity")).getCityId();	//获取当前城市ID
		System.out.println("Search: cityId=" + cityId);	//输出当前cityId
		
		List<Region> listReg = regBiz.listRegById(cityId);	//获取当前城市的所有区
		List<Premisetype> listPret = pretyBiz.listPremisetypes();	//获取所有楼盘类型
		List<Housetype> listHout = houtyBiz.listHousetypes();		//获取所有户型

		session.setAttribute("region", listReg);
		session.setAttribute("premisetype", listPret);
		System.out.println("PremiseType: " + listPret.size());
		session.setAttribute("housetype", listHout);

		////////////////////
		session.setAttribute("keyword", keyword);
		session.setAttribute("cityId", cityId);
		session.setAttribute("min", null);
		session.setAttribute("max", null);
		session.setAttribute("regId", null);
		session.setAttribute("htype", null);
		session.setAttribute("btype", null);
		////////////////////

		///////////////////////////////////////////////////////////////////
		// 每页12条数据
		listPre.setPageSize(12);
		// 从第一页开始
		listPre.setPageIndex(1);

		///////////////////////////////////////////////////////////////////

		//查询楼盘数据
		map.put("keyword", "%" + keyword + "%");
		listPre.setTotalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", "0");
		map.put("pageSize", "12");
		// map.put("cityId", String.valueOf(cityId));
		listPre.setList(premiseBiz.find(map));	//获取查询结果
		
		//获取当前页所有楼盘的均价
		List<Integer> avgPrices = new ArrayList<Integer>();
		System.out.println(listPre.getTotalRecords());
		
		for (int i = 0; i < listPre.getTotalRecords(); i++) {
			List<Premises> premisesList = listPre.getList();
			if (premisesList.size() == 0)
				continue;
			
			int buildId = premisesList.get(i).getBuildId();
			int price = premiseBiz.avgPremisePrice(buildId);
			System.out.println(buildId + ":" + price);
			avgPrices.add(price);
		}
		session.setAttribute("avgPrices", avgPrices);

		ModelAndView modelAndView = new ModelAndView("searchlist/Defaultlist");
		modelAndView.addObject("pagePre", listPre);
		modelAndView.addObject("totalPage", listPre.getTotalPage());
		return modelAndView;
	}

	@RequestMapping("/Location")
	public ModelAndView location(@RequestParam("cityId") int cityId) {
		System.out.println("Location:" + cityId);
		City currCity = cityBiz.getCityById(cityId);
		List<City> listCity = cityBiz.listCitys();
		request.getSession().setAttribute("currCity", currCity);
		request.getSession().setAttribute("listCity", listCity);
		return new ModelAndView("Home");
	}
}
