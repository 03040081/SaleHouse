package zsc.gof.dao;


import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Region;

/**
 * @author lewis
 * 区域数据访问层
 * */
public interface RegionDao {
	
	/**
	 * @author lewis
	 * @param 区域id
	 * @return 查询的Region对象
	 * */
	@Select("SELECT * FROM region AS r WHERE r.regionId = #{id}")
	@Results({
		@Result(id=true,column="regionId",property="regionId"),
		@Result(column="regionName",property="regionName"),
		@Result(column="cityId",property="city",
		one=@One(select="zsc.gof.dao.CityDao.quertCityById"))
	})
	public Region queryRegionById(int id); 
	
	
	@Select("SELECT * FROM region AS r WHERE r.cityId = #{id}")
	@Results({
		@Result(id=true,column="regionId",property="regionId"),
		@Result(column="regionName",property="regionName"),
		@Result(column="cityId",property="city",
		one=@One(select="zsc.gof.dao.CityDao.quertCityById"))
	})
	public List<Region> queryReginonListByCityId(int id);
}
