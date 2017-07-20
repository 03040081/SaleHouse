package zsc.gof.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Premisesimg;

public interface PremisesimgDao {
	
	/**
	 * @author lewis
	 * @param 楼盘id
	 * @return 楼盘图片
	 * */
	@Select("SELECT * FROM premisesimg AS pimg WHERE pimg.buildId = #{id}")
	public List<Premisesimg> queryPremisesimgByBuildId(int id);
	
	/**
	 * @author lewis
	 * @param 楼盘图片对象
	 * @return 
	 * */
	@Insert("INSERT INTO premisesimg(buildId,imgurl) VALUES(#{buildId},#{imgUrl})")
	public void insertPremisesimg(Premisesimg premisesimg);
}
