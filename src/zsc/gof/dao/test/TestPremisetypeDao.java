package zsc.gof.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zsc.gof.dao.PremisetypeDao;
import zsc.gof.entity.Premisetype;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class TestPremisetypeDao {
	@Autowired PremisetypeDao dao;
	@Test public void test(){
		System.out.println(dao.queryPremisetypeBybuildType(2).getTypeName());
	}
	@Test public void testqueryPremisetypeList(){
		List<Premisetype> list = dao.queryPremisetypeList();
		System.out.println(list);
	}
}
