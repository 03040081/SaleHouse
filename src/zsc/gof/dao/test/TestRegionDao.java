package zsc.gof.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.RegionDao;
import zsc.gof.entity.Region;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestRegionDao {
	
	@Autowired 
	RegionDao dao;
	
	@Test
	public void testqueryRegionById(){
		Region region = dao.queryRegionById(1);
		System.out.println(region.getRegionName());
	}
	@Test
	public void testqueryReginonListByCityId(){
		List<Region> region = dao.queryReginonListByCityId(2);
		System.out.println(region.size());
	}
}
