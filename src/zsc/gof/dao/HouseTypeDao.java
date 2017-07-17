package zsc.gof.dao;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Housetype;

public interface HouseTypeDao {
	
	/**
	 * @author lewis
	 * @param 房子类型id
	 * @return 返回对应房屋类型
	 * */
	@Select("SELECT * FROM housetype AS h WHERE h.htypeId = #{id}")
	public Housetype queryHouseTypeByHouseTypeId(int id);
}
