package zsc.gof.controller;

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

import zsc.gof.biz.HousetypeBiz;
import zsc.gof.biz.PremiseBiz;
import zsc.gof.biz.PremisetypeBiz;
import zsc.gof.biz.RegionBiz;
import zsc.gof.dao.PremisesDao;
import zsc.gof.dao.PremisetypeDao;
import zsc.gof.entity.Housetype;
import zsc.gof.entity.PageModel;
import zsc.gof.entity.Premises;
import zsc.gof.entity.Premisetype;
import zsc.gof.entity.Region;

@Controller
public class SecondCer {
	
	@Autowired
	RegionBiz regBiz;
	@Autowired
	PremisetypeBiz pretyBiz;
	@Autowired
	HousetypeBiz houtyBiz;
	@Autowired
	HttpServletRequest request;
	@Autowired
	PremiseBiz premiseBiz;
	//@Autowired 
	//PremisesDao dao;
	
	/*
	 * 从首页跳转到第二个页面
	 * 缺少分页函数
	 * 缺少通过城市编号查询，获取整个城市下的楼盘信息
	 */
	/*@RequestMapping("/search")
	public ModelAndView listCondition(@RequestParam("cityId")int cityId,
			@RequestParam("keyword")String keyword,@RequestParam("pageIndex")int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		Map<String, String>map=new HashMap<String, String>();
		
		HttpSession session=request.getSession();
		List<Region> listReg=regBiz.listRegById(cityId);
		List<Premisetype> listPret=pretyBiz.listPremisetypes();
		List<Housetype> listHout=houtyBiz.listHousetypes();
		session.setAttribute("region", listReg);
		session.setAttribute("premistype", listPret);
		session.setAttribute("housetype", listHout);
		
		
		
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
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		//map.put("cityId", String.valueOf(cityId));
		listPre.setList(premiseBiz.find(map));
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre", listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;
	}*/
	/*
	 * 切换城市
	 * 然后跳转至列表查询页面
	 * 
	 */
	/*@RequestMapping("/changecity")
	public ModelAndView changeCity(@RequestParam("cityId") int cityId,
			@RequestParam("keyword")String keyword){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		
		List<Region> listRegions=regBiz.listRegById(cityId);
		session.setAttribute("region", listRegions);
		listPre.setPageIndex(1);
		listPre.setPageSize(12);
		map.put("keyword", "%"+keyword+"%");
		listPre.setToltalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", "0");
		map.put("pageSize", "12");
		
		listPre.setList(premiseBiz.find(map));
		//List<Premises> list=premiseBiz.find(map);
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre",listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;
	}*/
	/* 第二个界面搜索
	 * 区域 、 均价 、 户型 、 类型 
	 * 时查询出楼盘信息
	 */
	@RequestMapping("/changeC")
	public ModelAndView changeCondition(HttpServletRequest request){
		
		String keyword=request.getParameter("keyword");
		String min=request.getParameter("min");
		String max=request.getParameter("max");
		String regionId=request.getParameter("regionId");
		String housetype=request.getParameter("housetype");
		String buildType=request.getParameter("buildType");
		
		
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(0);
		listPre.setPageSize(12);
		
		if(!"".equals(keyword)&&keyword!=null)
			session.setAttribute("keyword", keyword);
		if("".equals(keyword)||keyword==null)
			keyword=(String) session.getAttribute("keyword");
		
		if(min!=null&&"".equals(min)){
			session.setAttribute("min", min);
			session.setAttribute("max", max);
		}
		if("".equals(min)||min==null){
			min=(String) session.getAttribute("min");
			max=(String) session.getAttribute("max");
		}
		if("0".equals(min)){
			min=null;
			max=null;
			session.setAttribute("min", null);
			session.setAttribute("max", null);
		}
		
		if(regionId!=null&&!"".equals(regionId))
			session.setAttribute("regId", regionId);
		if("".equals(regionId)||regionId==null){
			regionId=(String) session.getAttribute("regId");
			//System.out.println("regiogId为空");
		}
		if("0".equals(regionId)){
			regionId=null;
			session.setAttribute("regId", null);
		}
		
		if(housetype!=null&&!"".equals(housetype))
			session.setAttribute("htype", housetype);
		if("".equals(housetype)||housetype==null)
			housetype=(String) session.getAttribute("htype");
		if("0".equals(housetype)){
			housetype=null;
			session.setAttribute("htype", null);
		}
		
		if(buildType!=null&&!"".equals(buildType))
			session.setAttribute("btype", buildType);
		if("".equals(buildType)||buildType==null)
			buildType=(String) session.getAttribute("btype");
		if("0".equals(buildType)){
			buildType=null;
			session.setAttribute("btype", null);
		}
		
		int flag=0;

		if(!keyword.equals("null")&&!keyword.equals("")&&keyword!=null){
			map.put("keyword", "%"+keyword+"%");
			flag++;
		}
		if(min!=null){
			map.put("min", min);
			map.put("max", max);
			flag++;
		}
		if(regionId!=null){
			map.put("regionId", regionId);
			flag++;
		}
		if(housetype!=null){
			map.put("housetype", housetype);
			flag++;
		}
		if(buildType!=null){
			map.put("buildType", buildType);
			flag++;
		}
		if(flag==0)
			map.put("keyword","%");
		listPre.setToltalRecords(premiseBiz.totalPremises(map));//总页数
		//int x=premiseBiz.totalPremises(map);
		map.put("pageIndex", String.valueOf(0));//修改查询条件时，从第0条数据开始查询返回
		map.put("pageSize", String.valueOf(12));
		
		System.out.println("keyword!!!!!:"+map.get("keyword"));
		System.out.println("regionId###:"+map.get("regionId"));
		
		listPre.setList(premiseBiz.find(map));
		ModelAndView modelAndView=new ModelAndView("index2");
		
		modelAndView.addObject("pagePre",listPre);//楼盘信息
		modelAndView.addObject("totalPage",listPre.getTotalPage());//总页数
		
		return modelAndView;
	}
	/*
	 * 上一页
	 */
	@RequestMapping("/previousPage")
	public ModelAndView previousPage(@RequestParam("pageIndex")int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(pageIndex);//设置当前页
		listPre.setPageSize(12);
		
		String keyword=(String) session.getAttribute("keyword");
		String min=(String) session.getAttribute("min");
		String max=(String) session.getAttribute("max");
		String regionId=(String) session.getAttribute("regionId");
		String housetype=(String) session.getAttribute("housetype");
		String buildType=(String) session.getAttribute("buildType");
		
		int flag=0;
		if(!keyword.equals("null")&&!keyword.equals("")&&keyword!=null){
			map.put("keyword", "%"+keyword+"%");
			flag++;
		}
		if(min!=null){
			map.put("min", min);
			map.put("max", max);
			flag++;
		}
		if(regionId!=null){
			map.put("regionId", regionId);
			flag++;
		}
		if(housetype!=null){
			map.put("housetype", housetype);
			flag++;
		}
		if(buildType!=null){
			map.put("buildType", buildType);
			flag++;
		}
		if(flag==0)
			map.put("keyword","%");
		listPre.setToltalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", String.valueOf((listPre.getPreviousPage()-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		listPre.setList(premiseBiz.find(map));
		
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre",listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;
	}
	/*
	 * 下一页
	 */
	@RequestMapping("/nextPage")
	public ModelAndView nextPage(@RequestParam("pageIndex") int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(pageIndex);//设置当前页
		listPre.setPageSize(12);
		
		String keyword=(String) session.getAttribute("keyword");
		String min=(String) session.getAttribute("min");
		String max=(String) session.getAttribute("max");
		String regionId=(String) session.getAttribute("regionId");
		String housetype=(String) session.getAttribute("housetype");
		String buildType=(String) session.getAttribute("buildType");
		
		int flag=0;
		if(!keyword.equals("null")&&!keyword.equals("")&&keyword!=null){
			map.put("keyword", "%"+keyword+"%");
			flag++;
		}
		if(min!=null){
			map.put("min", min);
			map.put("max", max);
			flag++;
		}
		if(regionId!=null){
			map.put("regionId", regionId);
			flag++;
		}
		if(housetype!=null){
			map.put("housetype", housetype);
			flag++;
		}
		if(buildType!=null){
			map.put("buildType", buildType);
			flag++;
		}
		if(flag==0)
			map.put("keyword","%");
		listPre.setToltalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", String.valueOf((listPre.getNextPage()-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		
		listPre.setList(premiseBiz.find(map));
		
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre",listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;
	}
	
	/*
	 * 跳到第 几 页
	 */
	@RequestMapping("/indexPage")
	public ModelAndView indexPage(@RequestParam("pageIndex") int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(pageIndex);//设置当前页
		listPre.setPageSize(12);
		
		String keyword=(String) session.getAttribute("keyword");
		String min=(String) session.getAttribute("min");
		String max=(String) session.getAttribute("max");
		String regionId=(String) session.getAttribute("regionId");
		String housetype=(String) session.getAttribute("housetype");
		String buildType=(String) session.getAttribute("buildType");
		
		int flag=0;

		if(!keyword.equals("null")&&!keyword.equals("")&&keyword!=null){
			map.put("keyword", "%"+keyword+"%");
			flag++;
		}
		if(min!=null){
			map.put("min", min);
			map.put("max", max);
			flag++;
		}
		if(regionId!=null){
			map.put("regionId", regionId);
			flag++;
		}
		if(housetype!=null){
			map.put("housetype", housetype);
			flag++;
		}
		if(buildType!=null){
			map.put("buildType", buildType);
			flag++;
		}
		if(flag==0)
			map.put("keyword","%");
		listPre.setToltalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", String.valueOf((pageIndex-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		
		listPre.setList(premiseBiz.find(map));
		
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre",listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;
	}
}
