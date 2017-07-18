package zsc.gof.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		System.out.println(premises.getBuildAddress());
		
	}
	
	@Test public void testsearch(){
		Map<String, String> map = new HashMap<String, String>();
//		map.put("min", "100");
//		map.put("max", "200");
//		map.put("regionId","2");
//		map.put("housetype","1");
//		map.put("buildType", "1");
//		map.put("keyword", "%GZ%");
//		map.put("pageSize","10");
//		map.put("pageIndex","0");
		List<Premises> premises= dao.search(map);
		System.out.println(premises.size());
	}
	
	@Test public void testsearchRecord(){
		Map<String, String> map = new HashMap<String, String>();
//		map.put("min", "100");
//		map.put("max", "200");
//		map.put("regionId","2");
//		map.put("housetype","1");
//		map.put("buildType", "1");
		map.put("keyword", "%");
		int premises= dao.queryTotalRecord(map);
		System.out.println(premises);
	}
}
