package zsc.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.CityBiz;
import zsc.gof.entity.City;


@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired//自动装配(即自动创建对象)
	CityBiz cityBiz;
	
	@RequestMapping("/index1")
	public  ModelAndView index() {
		int id=0;
		List<City> list=cityBiz.listCityById(id);
		return new ModelAndView("index");
	}
	
}
