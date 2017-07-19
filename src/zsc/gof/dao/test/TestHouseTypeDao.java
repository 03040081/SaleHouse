package zsc.gof.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.HouseTypeDao;
import zsc.gof.entity.Housetype;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestHouseTypeDao {
	@Autowired HouseTypeDao dao;
	
	@Test public void test(){
		System.out.println(dao.queryHouseTypeByHouseTypeId(6).getTypeName());
	}
	@Test public void testqueryHouseTypeList(){
		List<Housetype> list =  dao.queryHouseTypeList();
		System.out.println(list.size());
	}
}
