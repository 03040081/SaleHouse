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
	@Autowired
	PremisesDao dao;
	
	@Test public void testqueryPremisesById(){
		Premises premises = dao.queryPremisesByBuildId(233);
		System.out.println(premises.getBuildId());
		dao.insertPremises(premises);
		System.out.println(premises.getBuildId());
	}
	
	@Test public void testsearch(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("buildType", "3");
		List<Premises> premises= dao.search(map);
		System.out.println(premises.size());
	}
	
	@Test public void testsearchRecord(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("min", null);
		map.put("max", null);
		map.put("regionId",null);
		map.put("housetype","2");
		map.put("buildType", "2");
		map.put("keyword", "%");
		int premises= dao.queryTotalRecord(map);
		System.out.println(premises);
	}
	
	
}
