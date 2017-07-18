package zsc.gof.biz;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import zsc.gof.entity.House;

public interface HouseBiz {
	
	/*
	 * 搜索
	 * 房子均价
	 */
	public List<House> listHouse(int buildId);
	
	public int addHouse(House house);
	
	public int updateHouse(House house);
	
	public int deleteHouse(int id);
}
