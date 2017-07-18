package zsc.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import zsc.gof.biz.UserInfoBiz;
import zsc.gof.entity.Role;
import zsc.gof.entity.Userinfo;

@Controller
public class Register {
	
	@Autowired
	UserInfoBiz Biz;
	@Autowired
	Userinfo userinfo;
	@Autowired
	Role role;
	/*
	 * 注册用户
	 */
	@RequestMapping("/register")
	public String register(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("locked")int locked,@RequestParam("faceing")String faceing,@RequestParam("roleId")int roleId){
		
		int user=Biz.judgeUser(username);//用户角色、、、、、、、、、、、、、、、、、、
		
		if(user<=0){
			userinfo.setUsername(username);
			userinfo.setPassword(password);
			///userinfo.setLocked(locked);默认值
			userinfo.setFaceing(faceing);
			role.setRoleId(roleId);
			userinfo.setRole(role);
			Biz.register(userinfo);
			return "loginU";
		}else{
			return "register";
		}
	}
}
