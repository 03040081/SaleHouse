package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.Province;

public interface ProvinceBiz {
	/*
	 * 搜索
	 * 省份列表
	 */
	public List<Province> listPro();
	
	/*
	 * 添加省份
	 */
	public int addProvince(Province province);
	
	public int updateProvince(Province id);
	
	public int deleteProvince(int id);
}
