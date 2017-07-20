package zsc.gof.dao;

import java.util.List;
import java.util.Map;





import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import zsc.gof.entity.Premises;

/**
 * @author lewis
 *	楼盘数据访问层
 */
public interface PremisesDao {
	
	/**
	 * @author lewis
	 * @param 动态多个查询参数
	 * 			map可包含以下Key-Value参数：
	 * 			map.put("min", "100");	价格左区间	
	 *			map.put("max", "200");	价格右区间
	 *			map.put("regionId","2");区域id
	 *			map.put("housetype","1");  户型
	 *			map.put("buildType", "1"); 类型
	 *			map.put("keyword", "%GZ%"); 关键字查询
	 *		    map.put("pageSize","10");		页面大小
	 *		    map.put("pageIndex","0");		当前页
	 * @return 根据多个条件查询楼盘的列表
	 */
	public List<Premises> search(Map map);
	
	/**
	 * @author lewis
	 * @param 动态多个查询参数
	 * @return 根据区域id条件查询楼盘的列表
	 */
	public Premises queryPremisesByBuildId(int buildId);
	
	/**
	 * @author lewis
	 * @param 动态多个查询参数
	 * 			map可包含以下Key-Value参数：
	 * 			map.put("min", "100");	价格左区间	
	 *			map.put("max", "200");	价格右区间
	 *			map.put("regionId","2");区域id
	 *			map.put("housetype","1");  户型
	 *			map.put("buildType", "1"); 类型
	 *			map.put("keyword", "%GZ%"); 关键字查询
	 *			
	 * @return 根据多个条件查询楼盘的总记录数大小
	 */
	public int queryTotalRecord(Map map);
	
	
	/**
	 * @author lewis
	 * @param	楼盘类
	 * @return 
	 * **/
	@Insert("INSERT INTO premises(buildName,inOpen,inLive,households,propertyRight,propertyCosts,buildArea,floorArea,buildAddress,buildType,developer,regionId,iconUrl) VALUES(#{buildName},#{inOpen},#{inLive},#{households},#{propertyRight},#{propertyCosts},#{buildArea},#{floorArea},#{buildAddress},#{premisetype.btypeId},#{developer},#{region.regionId},#{iconUrl})")
	@SelectKey(statement="select last_insert_id()",before=false,resultType=int.class,keyProperty="buildId")
	public void insertPremises(Premises premises);
	
	/**
	 * @author lewis
	 * @param	楼盘id
	 * @return 	楼盘房子的平均价格
	 * */
	@Select("SELECT AVG(h.housePrice) FROM house AS h WHERE h.buildId = #{id}")
	public int queryAvgPremisesByBuildId(int build) ;
}
