package zsc.gof.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
	
	/*@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;*/
	
	/*
	 * 登录 并且使用Cookie实现自动登录
	 */
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
		int userId=0;//////////////////////////////////?????????????
		if(true){
			HttpSession session=request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
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
}
