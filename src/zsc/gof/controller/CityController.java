package zsc.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.CityService;
import zsc.gof.entity.City;


@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired//自动装配(即自动创建对象)
	CityService cityService;
	
	@RequestMapping("/index1")
	public  ModelAndView index() {
		City city = cityService.queryCityById(1);
		
		return new ModelAndView("index");
	}
	@RequestMapping("/index2")
	public String fun(@RequestParam("password") int pass){
		
		
		return null;
		
	}
}
