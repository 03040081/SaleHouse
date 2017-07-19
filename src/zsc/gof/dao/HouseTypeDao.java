package zsc.gof.dao;

import java.util.List;

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
	
	
	/**
	 * @author lewis
	 * @param 
	 * @return 返回房屋类型列表
	 * */
	@Select("SELECT * FROM housetype AS h")
	public  List<Housetype> queryHouseTypeList();
}
