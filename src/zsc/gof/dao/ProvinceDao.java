package zsc.gof.dao;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Province;

public interface ProvinceDao {

	
	/**
	 * @author lewis
	 * @param 根据id查询出省份
	 * @return 放回对应id的省份对象
	 * */
	@Select("SELECT * FROM province WHERE  provinceId = #{id}")
	public Province queryProvinceById(int id);
}
