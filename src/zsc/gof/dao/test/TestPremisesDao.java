package zsc.gof.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.PremisesDao;
import zsc.gof.entity.Premises;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestPremisesDao {
	@Autowired PremisesDao dao;
	
	@Test public void testqueryPremisesById(){
		Premises premises = dao.queryPremisesById(1);
		System.out.println(premises.getRegion().getCity().getProvince().getProvinceName());
	}
}
