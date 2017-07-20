package zsc.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.CityBiz;

@Controller//标志为控制器
public class Base {

	@Autowired
	CityBiz cityBiz;
	
	@RequestMapping("/Index")//访问地址
	public  ModelAndView index() {		
		return new ModelAndView("forward:City?pageNo=1&cityId=1");
	}
}
