package zsc.gof.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
	
	@RequestMapping("/ToLogin")
	public ModelAndView Login(){
		return new ModelAndView("Logins/Login");
	}
}
