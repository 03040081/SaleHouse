package zsc.gof.dao;

import java.util.List;
import java.util.Map;



import org.apache.ibatis.annotations.Select;

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
	public Premises queryPremisesById(int regionId);
	
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
	
	@Select("SELECT * FROM `premises` AS p WHERE p.buildId =#{id}")
	public Premises queryPremisesByBuildId(int id);
}
