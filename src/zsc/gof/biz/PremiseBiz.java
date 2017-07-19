package zsc.gof.biz;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.Premises;

public interface PremiseBiz {
	/*
	 * 使用动态SQL，查询楼盘信息
	 */
	public List<Premises> find(Map map);
	/*
	 * 定位
	 * 查找楼盘
	 */
	public Premises findOne(int buildId);
	/*
	 * 添加楼盘信息
	 */
	public int addPremise(Premises premises);
	/*
	 * 修改楼盘信息
	 */
	public int updatePremises(Premises premises);
	/*
	 * 删除楼盘信息
	 */
	public int deletePremises(int buildId);
	/*
	 * 计算楼盘数量
	 */
	public int totalPremises(Map map);
}
