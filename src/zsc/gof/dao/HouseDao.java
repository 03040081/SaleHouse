package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.House;

public interface HouseDao {
	
	@Select("")
	@Results({
		@Result(),
	})
	public List<House> queryHouseByBuildId(int id);
}
