package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.HouseImg;

public interface HouseImgDao {
	
	@Select("SELECT * FROM houseimg AS h WHERE h.houseId = #{id}")
	public List<HouseImg> queryHouseImgByHouseId(int id);
}
