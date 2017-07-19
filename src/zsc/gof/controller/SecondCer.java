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
	/* 切 换
	 * 区域 、 均价 、 户型 、 类型 
	 * 时查询出楼盘信息
	 */
	@RequestMapping("/changeC")
	public ModelAndView changeCondition(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(0);
		listPre.setPageSize(12);
		
		if(keyword=="")
			keyword=(String) session.getAttribute("keyword");
		if(keyword=="0")
			keyword=null;
		if(min==""){
			min=(String) session.getAttribute("min");
			max=(String) session.getAttribute("max");
		}
		if(min=="0"){
			min=null;
			max=null;
		}
		if(regionId=="")
			regionId=(String) session.getAttribute("regionId");
		if(regionId=="0")
			regionId=null;
		if(housetype=="")
			housetype=(String) session.getAttribute("housetype");
		if(housetype=="0")
			housetype=null;
		if(buildType=="")
			buildType=(String) session.getAttribute("buildType");
		if(buildType=="0")
			buildType=null;
		
		
		map.put("keyword", "%"+keyword+"%");
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
		listPre.setToltalRecords(premiseBiz.totalPremises(map));
		map.put("pageIndex", String.valueOf(listPre.getPageIndex()));//修改查询条件时，从第0条数据开始查询返回
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		listPre.setList(premiseBiz.find(map));
		//List<Premises> list=premiseBiz.find(map);
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("pagePre",listPre);
		modelAndView.addObject("totalPage",listPre.getTotalPage());
		return modelAndView;
	}
	/*
	 * 上一页
	 */
	@RequestMapping("/previousPage")
	public ModelAndView previousPage(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType,@RequestParam("pageIndex")int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(pageIndex);//设置当前页
		listPre.setPageSize(12);
		
		keyword=(String) session.getAttribute("keyword");
		min=(String) session.getAttribute("min");
		max=(String) session.getAttribute("max");
		regionId=(String) session.getAttribute("regionId");
		housetype=(String) session.getAttribute("housetype");
		buildType=(String) session.getAttribute("buildType");
		
		map.put("keyword", "%"+keyword+"%");
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
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
	public ModelAndView nextPage(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType,@RequestParam("pageIndex") int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(pageIndex);//设置当前页
		listPre.setPageSize(12);
		
		keyword=(String) session.getAttribute("keyword");
		min=(String) session.getAttribute("min");
		max=(String) session.getAttribute("max");
		regionId=(String) session.getAttribute("regionId");
		housetype=(String) session.getAttribute("housetype");
		buildType=(String) session.getAttribute("buildType");
		
		map.put("keyword", "%"+keyword+"%");
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
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
	 * 下一页
	 */
	@RequestMapping("/indexPage")
	public ModelAndView indexPage(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType,@RequestParam("pageIndex") int pageIndex){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		listPre.setPageIndex(pageIndex);//设置当前页
		listPre.setPageSize(12);
		
		keyword=(String) session.getAttribute("keyword");
		min=(String) session.getAttribute("min");
		max=(String) session.getAttribute("max");
		regionId=(String) session.getAttribute("regionId");
		housetype=(String) session.getAttribute("housetype");
		buildType=(String) session.getAttribute("buildType");
		
		map.put("keyword", "%"+keyword+"%");
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
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
