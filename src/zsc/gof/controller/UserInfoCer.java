package zsc.gof.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import zsc.gof.biz.UserInfoBiz;
import zsc.gof.entity.Role;
import zsc.gof.entity.Userinfo;

@Controller
public class UserInfoCer {
	
	@Autowired
	UserInfoBiz Biz;
	@Autowired
	Userinfo userinfo;
	@Autowired
	Role role;
	
	@Autowired
	UserInfoBiz userInfoBiz;
	
	@RequestMapping("/loginU")
	public String Login(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletRequest request,HttpServletResponse response){
		/*
		 * if 登录
		 */
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("myusername")){
					username=cookies[i].getValue();
				}
				if(cookies[i].getName().equals("mypassword")){
					password=cookies[i].getValue();
				}
			}
		}
		userinfo=userInfoBiz.login(username, password);
		if(userinfo!=null){
			HttpSession session=request.getSession();
			session.setAttribute("userInfo", userinfo);
			
			if(cookies==null){
				Cookie myusername=new Cookie("myusername", username);
				Cookie mypassword=new Cookie("mypassword", password);
				response.addCookie(myusername);
				response.addCookie(mypassword);
			}
			return "index";
		}else{
			return "loginU";
		}

	}
	/*
	 * 注销
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.invalidate();
	}
	
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
	
	
	
	@RequestMapping("/updateUser")
	public String updateUser(Userinfo userinfo){
		userInfoBiz.update(userinfo);
		return "userinfo";
	}
}
