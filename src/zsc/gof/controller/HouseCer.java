package zsc.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.HouseBiz;
import zsc.gof.biz.PremiseBiz;
import zsc.gof.entity.House;
import zsc.gof.entity.Premises;

@Controller
public class HouseCer {
	@Autowired
	PremiseBiz premiseBiz;
	@Autowired
	HouseBiz houseBiz;
	
	@RequestMapping("/index3")
	public ModelAndView premisAndHouse(@RequestParam("buildId")int buildId){
		Premises premises=premiseBiz.findOne(buildId);
		List<House> listHouses=houseBiz.listHouse(buildId);
		ModelAndView modelAndView=new ModelAndView("index3");
		modelAndView.addObject("premises",premises);
		modelAndView.addObject("listHouses", listHouses);
		return modelAndView;
	}
	
}
