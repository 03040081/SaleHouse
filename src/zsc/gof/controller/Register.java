package zsc.gof.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Register {
	/*
	 * 注册用户
	 */
	@RequestMapping("/register")
	public String register(@RequestParam("username")String username,@RequestParam("password")String password){
		
		int role=0;//用户角色、、、、、、、、、、、、、、、、、、
		
		if(true){
			return "loginU";
		}else{
			return "register";
		}
	}
}
