package zsc.gof.dao;

import java.util.List;


import zsc.gof.entity.House;

public interface HouseDao {
	
	/**
	 * @author lewis
	 * @param 楼盘id
	 * @return 对应楼盘id中的房子列表
	 * */
	public List<House> queryHouseByBuildId(int id);
}
