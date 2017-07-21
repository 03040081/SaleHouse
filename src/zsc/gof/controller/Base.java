package zsc.gof.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//标志为控制器
public class Base {
	@RequestMapping("/Index")//访问地址
	public  ModelAndView index() {		
		return new ModelAndView("forward:City?pageNo=1&cityId=1");
	}
}
