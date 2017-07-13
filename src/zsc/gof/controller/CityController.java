package zsc.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.CityService;
import zsc.gof.entity.City;


@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@RequestMapping("/index")
	public  ModelAndView index() {
		City city = cityService.queryCityById(1);
		
		System.out.printf("%d %s %d\n",city.getCityId(),city.getCityName(),city.getCityId());
		
		return new ModelAndView("index");
	}
}
