package zsc.gof.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	HttpSession session;
	@Autowired
	PremiseBiz premiseBiz;
/*	@Autowired
	Map<String, String> map;*/
	/*
	 * 从首页跳转到第二个页面
	 * 
	 */
	@RequestMapping("/search")
	public ModelAndView listCondition(@RequestParam("cityId")int cityId,
			@RequestParam("keyword")String keyword){
		List<Region> listReg=regBiz.listRegById(cityId);
		List<Premisetype> listPret=pretyBiz.listPremisetypes();
		List<Housetype> listHout=houtyBiz.listHousetypes();
		session.setAttribute("region", listReg);
		session.setAttribute("premistype", listPret);
		session.setAttribute("housetype", listHout);
		Map<String, String> map=new HashMap<String, String>();
		map.put("keyword", keyword);
		//map.put("cityId", String.valueOf(cityId));
		List<Premises> list=premiseBiz.find(map);
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	/*
	 * 切换城市
	 * 然后跳转至首页
	 */
	@RequestMapping("/changecity")
	public ModelAndView changeCity(@RequestParam("cityId") int cityId,
			@RequestParam("keyword")String keyword){
		List<Region> listRegions=regBiz.listRegById(cityId);
		session.setAttribute("region", listRegions);
		Map<String, String> map=new HashMap<String, String>();
		map.put("keyword", keyword);
		List<Premises> list=premiseBiz.find(map);
		ModelAndView modelAndView=new ModelAndView("index2");
		modelAndView.addObject(list);
		return modelAndView;
	}
	
	@RequestMapping("/changeC")
	public ModelAndView changeCondition(@RequestParam("keyword")String keyword,
			@RequestParam("min")String min,@RequestParam("max")String max,
			@RequestParam("regionId")String regionId,@RequestParam("type")String type){
		return null;
	}
}
