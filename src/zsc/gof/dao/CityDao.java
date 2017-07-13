package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.City;

public interface CityDao {
	
	public List<City> queryCity();
	
	@Select("SELECT * FROM city WHERE cityid = #{id}")
	@Results({
		@Result(id=true,column="",property=""),
		@Result(column="",property=""),
		
	})
	public City quertCityById(int id);
}
