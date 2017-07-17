package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.City;

public interface CityDao {
	
	/**
	 * @author lewis
	 * @param
	 * @return 返回查询的City数组对象
	 * */
	
	public List<City> queryCity();
	
	
	
	/**
	 * @author lewis
	 * @param 城市id
	 * @return 返回查询的City对象
	 * */
	@Select("SELECT * FROM city WHERE cityid = #{id}")
	@Results({
		@Result(id=true,column="cityId",property="cityId"),
		@Result(column="cityName",property="cityName"),
		@Result(column="provinceId",property="province",
		one=@One(select="zsc.gof.dao.ProvinceDao.queryProvinceById"))
	})
	public City quertCityById(int id);
}
