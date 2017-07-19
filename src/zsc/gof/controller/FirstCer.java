package zsc.gof.controller;

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

import zsc.gof.biz.HousetypeBiz;
import zsc.gof.biz.PremiseBiz;
import zsc.gof.biz.PremisetypeBiz;
import zsc.gof.biz.RegionBiz;
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
	/*
	 * 从首页输入模糊查询
	 * 跳转至列表找房子
	 */
	@RequestMapping("/Search")
	public ModelAndView search(@RequestParam("keyword")String keyword,@RequestParam("cityId")int cityId){
		Map<String,String> map=new HashMap<String, String>();
		PageModel<Premises> listPre=new PageModel<Premises>();
		
		HttpSession session=request.getSession();
		List<Region> listReg=regBiz.listRegById(cityId);
		List<Premisetype> listPret=pretyBiz.listPremisetypes();
		List<Housetype> listHout=houtyBiz.listHousetypes();
		session.setAttribute("region", listReg);
		session.setAttribute("premistype", listPret);
		session.setAttribute("housetype", listHout);
		
		////////////////////
		session.setAttribute("keyword", keyword);
		session.setAttribute("cityId", cityId);
		////////////////////
		

		///////////////////////////////////////////////////////////////////
		//每页12条数据
		listPre.setPageSize(12);
		//从第一页开始
		listPre.setPageIndex(1);
		
		///////////////////////////////////////////////////////////////////
		//Map<String, String> map=new HashMap<String, String>();
		map.put("keyword", "%"+keyword+"%");
		listPre.setToltalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", "0");
		map.put("pageSize", "12");
		//map.put("cityId", String.valueOf(cityId));
		listPre.setList(premiseBiz.find(map));
		
		//ModelAndView modelAndView =new ModelAndView("searchlist/Defaultlist");

		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre", listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;

	}
	
}
