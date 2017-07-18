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
	/*@Autowired
	HttpSession session;*/
	@Autowired
	PremiseBiz premiseBiz;
	/*@Autowired
	PageModel<Premises> listPre;
	@Autowired
	Map<String, String> map;*/
/*	@Autowired
	Map<String, String> map;*/
	/*
	 * 从首页跳转到第二个页面
	 * 缺少分页函数
	 * 缺少通过城市编号查询，获取整个城市下的楼盘信息
	 */
	@RequestMapping("/search")
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
		//楼盘总记录数
		listPre.setToltalRecords(premiseBiz.totalPremises());
		///////////////////////////////////////////////////////////////////
		//Map<String, String> map=new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("pageIndex", String.valueOf((pageIndex-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		//map.put("cityId", String.valueOf(cityId));
		
		listPre.setList(premiseBiz.find(map));
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("list", listPre);
		return modelAndView;
	}
	/*
	 * 切换城市
	 * 然后跳转至首页
	 * 
	 */
	@RequestMapping("/changecity")
	public ModelAndView changeCity(@RequestParam("cityId") int cityId,
			@RequestParam("keyword")String keyword){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		
		List<Region> listRegions=regBiz.listRegById(cityId);
		session.setAttribute("region", listRegions);
		//listPre.setPageIndex(1);
		//listPre.setPageSize(12);
		//listPre.setToltalRecords(premiseBiz.totalPremises());
		
		
		map.put("keyword", keyword);
		map.put("pageIndex", "0");
		map.put("pageSize", "12");
		listPre.setList(premiseBiz.find(map));
		//List<Premises> list=premiseBiz.find(map);
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject(listPre);
		return modelAndView;
	}
	/* 切 换
	 * 区域 、 均价 、 户型 、 类型 
	 * 时查询出楼盘信息
	 */
	@RequestMapping("/changeC")
	public ModelAndView changeCondition(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType,@RequestParam("pageIndex")int pageIndex){
		/////////////缺少分页函数
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("keyword", keyword);
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
		map.put("pageIndex", String.valueOf((pageIndex-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		listPre.setList(premiseBiz.find(map));
		//List<Premises> list=premiseBiz.find(map);
		ModelAndView modelAndView=new ModelAndView("/index2");
		modelAndView.addObject(listPre);
		return modelAndView;
	}
	/*
	 * 上一页
	 */
	@RequestMapping("/previousPage")
	public ModelAndView previousPage(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("keyword", keyword);
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
		map.put("pageIndex", String.valueOf((listPre.getPreviousPage()-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		listPre.setList(premiseBiz.find(map));
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("listPre",listPre);
		return modelAndView;
	}
	/*
	 * 下一页
	 */
	@RequestMapping("/nextPage")
	public ModelAndView nextPage(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("housetype")String housetype,
			@RequestParam("buildType")String buildType){
		PageModel<Premises> listPre=new PageModel<Premises>();
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("keyword", keyword);
		map.put("min", min);
		map.put("max", max);
		map.put("regionId", regionId);
		map.put("housetype", housetype);
		map.put("buildType", buildType);
		map.put("pageIndex", String.valueOf((listPre.getNextPage()-1)*listPre.getPageSize()));
		map.put("pageSize", String.valueOf(listPre.getPageSize()));
		listPre.setList(premiseBiz.find(map));
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("listPre",listPre);
		return modelAndView;
	}
	
}
