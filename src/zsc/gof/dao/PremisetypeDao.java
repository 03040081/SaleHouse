package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Premisetype;

public interface PremisetypeDao {
	/**
	 * @author lewis
	 * @param 楼盘id
	 * @return 返回对应id的楼盘类型
	 * */
	@Select("SELECT * FROM premisetype AS p WHERE p.btypeId = #{id}")
	public Premisetype queryPremisetypeBybuildType(int id); 
	
	/**
	 * @author lewis
	 * @param 楼盘id
	 * @return 返回楼盘类型列表
	 * */
	@Select("SELECT * FROM premisetype AS p")
	public List<Premisetype> queryPremisetypeList(); 
	
	
}
