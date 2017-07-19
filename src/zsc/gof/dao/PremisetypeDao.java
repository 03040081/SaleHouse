package zsc.gof.dao;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Premisetype;

public interface PremisetypeDao {
	@Select("SELECT * FROM premisetype AS p WHERE p.btypeId = #{id}")
	public Premisetype queryPremisetypeBybuildType(int id); 
}
