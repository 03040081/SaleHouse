package zsc.gof.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.RoleDao;
import zsc.gof.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestRoleDao {
	@Autowired RoleDao dao;
	
	@Test public void test(){
		Role role = dao.queryRoleByRoleId(1);
		System.out.println(role.getRoleName());
	}
}
