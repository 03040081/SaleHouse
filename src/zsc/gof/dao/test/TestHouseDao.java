package zsc.gof.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.HouseDao;
import zsc.gof.entity.House;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestHouseDao {
	@Autowired HouseDao dao;
	@Test public void test(){
		List<House> houses = dao.queryHouseByBuildId(1);
		System.out.println(houses.size());
	}
}
