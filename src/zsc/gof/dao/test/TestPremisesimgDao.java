package zsc.gof.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.PremisesimgDao;
import zsc.gof.entity.Premisesimg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestPremisesimgDao {
	@Autowired PremisesimgDao dao;
	@Test public void test(){
		System.out.println(dao.queryPremisesimgByBuildId(1118).get(1).getImgUrl());
	}
	
	@Test public void testinsertPremisesimg(){
		Premisesimg premisesimg = new Premisesimg();
		premisesimg.setBuildId(220);
		premisesimg.setImgUrl("123232");
		dao.insertPremisesimg(premisesimg);
		
	}
	
}
