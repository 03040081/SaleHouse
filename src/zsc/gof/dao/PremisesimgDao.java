package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Premisesimg;

public interface PremisesimgDao {
	
	/**
	 * @author lewis
	 * @param 楼盘id
	 * @return 楼盘图片
	 * */
	@Select("SELECT * FROM premisesimg AS p WHERE p.buildId = #{id}")
	public List<Premisesimg> queryPremisesimgByBuildId(int id);
}
