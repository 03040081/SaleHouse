package zsc.gof.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.PremisetypeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestPremisetypeDao {
	@Autowired PremisetypeDao dao;
	@Test public void test(){
		System.out.println(dao.queryPremisetypeBybuildType(2).getTypeName());
	}
}