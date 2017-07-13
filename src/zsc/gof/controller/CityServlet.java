package zsc.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zsc.gof.biz.CityService;
import zsc.gof.entity.City;


@Controller
public class CityServlet {
	
	@Autowired
	CityService cityService;
	
	@RequestMapping("/index")
	public String index() {
		List<City> cities = cityService.queryCity();
		for(City city:cities){
			System.out.printf("%d %s %d",city.getCityId(),city.getCityName(),city.getCityId());
		}
		System.out.println();
		return "index";
	}
}
