package zsc.gof.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.CityBiz;
import zsc.gof.entity.City;


@Controller
public class CityController {
	@Autowired
	HttpServletRequest request;
	@Autowired//自动装配(即自动创建对象)
	CityBiz cityBiz;
	
	@RequestMapping("/City")
	public  ModelAndView index(
			@RequestParam("cityId") int cityId, 
			@RequestParam("pageNo") int pageNo) {
		System.out.println("Location:" + cityId);
		City currCity = cityBiz.getCityById(cityId);
		List<City> listCity = cityBiz.listCitys();
		request.getSession().setAttribute("currCity", currCity);
		request.getSession().setAttribute("listCity", listCity);
		if (pageNo == 2)
			return new ModelAndView("searchlist/Defaultlist");
		return new ModelAndView("Homepage");
	}
	
}
