package zsc.gof.dao.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.UserDao;
import zsc.gof.entity.Role;
import zsc.gof.entity.Userinfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestUserDao {
	
	@Autowired
	private UserDao dao ;
	
	@Test
	public void testrRegister(){
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername("cat");
		userinfo.setPassword("123");
		userinfo.setFaceing("sanm");
		userinfo.setLocked(1);
		Role role = new Role();
		role.setRoleId(1);
		userinfo.setRole(role);
		
		System.out.println(dao.register(userinfo));
	}
	@Test
	public void testLogin(){
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername("tomcat");
		userinfo.setPassword("123");
		System.out.println(dao.login(userinfo).getUsername());
	}
	
	@Test
	public void testrUpdate(){
		Userinfo userinfo = new Userinfo();
		userinfo.setUserId(4);
		userinfo.setUsername("cat");
		userinfo.setPassword("123");
		userinfo.setFaceing("haha");
		userinfo.setLocked(1);
		Role role = new Role();
		role.setRoleId(1);
		userinfo.setRole(role);
		
		System.out.println(dao.updateInfo(userinfo));
	}
	@Test
	public void queryUserExist(){
		System.out.println(dao.queryUserExist("tovmcat"));
	}
}
