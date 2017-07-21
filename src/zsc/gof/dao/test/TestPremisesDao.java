package zsc.gof.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.biz.PremiseBiz;
import zsc.gof.dao.PremisesDao;
import zsc.gof.entity.Premises;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestPremisesDao {
	@Autowired
	PremisesDao dao;
	
	@Autowired PremiseBiz biz;
	@Test public void testqueryPremisesById(){
		Premises premises = dao.queryPremisesByBuildId(233);
		System.out.println(premises.getBuildId());
		dao.insertPremises(premises);
		System.out.println(premises.getBuildId());
	}
	
	@Test public void testsearch(){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("min", "0");
		map.put("max", "50");
		map.put("housetype","1");
		List<Premises> premises= biz.find(map);
		System.out.println(premises.size());
	}
	
	@Test public void testsearchRecord(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("min", "0");
		map.put("max", "50");
		
		//map.put("keyword", "%天誉半岛花园%");
		int premises= dao.queryTotalRecord(map);
		System.out.println(premises);
	}
	@Test public void testqueryAvgPremisesByBuildId(){
		System.out.println(dao.queryAvgPremisesByBuildId(1363));
	}
	
}
