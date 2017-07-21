package zsc.gof.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.UserInfoBiz;
import zsc.gof.entity.Region;
import zsc.gof.entity.Role;
import zsc.gof.entity.Userinfo;

@Controller
public class UserInfoCer {
	
	@Autowired
	UserInfoBiz Biz;
	/*@Autowired
	Userinfo userinfo;
	@Autowired
	Role role;
	*/
	@Autowired
	HttpServletRequest request;
	@Autowired
	UserInfoBiz userInfoBiz;
	
	@RequestMapping("/loginU")
	public ModelAndView Login(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletRequest request,HttpServletResponse response){
		/*
		 * if 登录
		 */
		ModelAndView modelAndView=new ModelAndView("Homepage");
		Userinfo userinfo=null;
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
		if(userinfo==null)
			return modelAndView;
		if(userinfo.getLocked()==0){//用户被锁定，不能登录
			return modelAndView;
		}
		if(userinfo!=null){
			HttpSession session=request.getSession();
			session.setAttribute("userInfo", userinfo);
			
			if(cookies==null){
				Cookie myusername=new Cookie("myusername", username);
				Cookie mypassword=new Cookie("mypassword", password);
				response.addCookie(myusername);
				response.addCookie(mypassword);
			}
			return modelAndView;
		}else{
			return modelAndView;
		}
		

	}
	/*
	 * 注销
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView()
	}
	
	/*
	 * 普通用户
	 * 注册用户
	 */
	@RequestMapping("/registerUser")
	public String registerUser(@RequestParam("file") MultipartFile file,@RequestParam("username")String username,
			@RequestParam("password")String password) throws IOException{
		Userinfo userinfo=new Userinfo();
		Role role=new Role();
		int user=Biz.judgeUser(username);//用户角色、、、、、、、、、、、、、、、、、、
		String filePath="";
		if(user<=0){//request.getSession().getServletContext().getRealPath("/") + 
			filePath = "upload/"+ file.getOriginalFilename();
			file.transferTo(new File(filePath));
			userinfo.setUsername(username);
			userinfo.setPassword(password);
			///userinfo.setLocked(locked);默认值
			userinfo.setFaceing(filePath);
			role.setRoleId(1);
			userinfo.setRole(role);
			Biz.register(userinfo);
			return "loginU";
		}else{
			return "register";
		}
	}
	/*
	 * 管理员用户
	 * 注册用户
	 */
	@RequestMapping("/registerManager")
	public String registerMag(@RequestParam("file") MultipartFile file,@RequestParam("username")String username,
			@RequestParam("password")String password)throws IOException{
		Userinfo userinfo=new Userinfo();
		Role role=new Role();
		int user=Biz.judgeUser(username);//用户角色、、、、、、、、、、、、、、、、、、
		String filePath="";
		if(user<=0){//request.getSession().getServletContext().getRealPath("/") + 
			filePath = "upload/"+ file.getOriginalFilename();
			file.transferTo(new File(filePath));
			userinfo.setUsername(username);
			userinfo.setPassword(password);
			///userinfo.setLocked(locked);默认值
			userinfo.setFaceing(filePath);
			role.setRoleId(2);
			userinfo.setRole(role);
			Biz.register(userinfo);
			return "loginU";
		}else{
			return "register";
		}
	}
	/*@RequestMapping("/updateUser")
	public String updateUser(Userinfo userinfo){
		userInfoBiz.update(userinfo);
		return "userinfo";
	}*/
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("locked")int locked,@RequestParam("faceing")String faceing,@RequestParam("roleId")int roleId){
		
		Userinfo userinfo=new Userinfo();
		userinfo.setUsername(username);
		userinfo.setPassword(password);
		userinfo.setLocked(locked);
		userinfo.setFaceing(faceing);
		Role role=new Role();
		role.setRoleId(roleId);
		userinfo.setRole(role);
		
		userInfoBiz.update(userinfo);
		return "userinfo";
	}
	@RequestMapping("/getUserInfo")
	public String getUserInfo(){
		//用户新在登录时已经保存至session中
		return "userInfo";
	}
}
