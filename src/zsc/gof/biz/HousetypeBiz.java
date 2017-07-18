package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.House;
import zsc.gof.entity.Housetype;

public interface HousetypeBiz {

	 public List<Housetype> listHousetypes();
	 
	 public int updateHousetype(Housetype house);
	 
	 public int addHousetype(Housetype house);
	 
	 public int deleteHousetype(int id);
}
