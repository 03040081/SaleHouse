package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.Region;

public interface RegionBiz {
	/*
	 * 搜索
	 * 区域列表
	 */
	//public List<Region> listReg();
	
	public List<Region> listRegById(int id);
	/*
	 * 添加区域
	 */
	public int addRegion(Region region);
	
	public int updateRegion(Region region);
	
	public int deleteRegion(int id);
}
