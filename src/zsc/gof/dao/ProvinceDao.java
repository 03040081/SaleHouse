package zsc.gof.dao;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Province;

public interface ProvinceDao {
	
	@Select("SELECT * FROM province WHERE  provinceId = #{id};")
	public Province queryProvinceById(int id);
}
