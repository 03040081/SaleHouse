package zsc.gof.dao;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.Premises;

/**
 * @author lewis
 *	楼盘数据访问层
 */
public interface PremisesDao {
	
	/**
	 * @author lewis
	 * @param 动态多个查询参数
	 * @return 楼盘的列表
	 */
	public List<Premises> search(Map map);
}
