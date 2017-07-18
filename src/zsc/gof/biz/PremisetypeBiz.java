package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.Premisetype;

public interface PremisetypeBiz {
	/*
	 * 搜索条件
	 * 楼盘 类别
	 */
	public List<Premisetype> listPremisetypes();
	
	public int addPremisetype(Premisetype premisetype);
	
	public int updatePremisetype(Premisetype premisetype);
	
	public int deletePremisetype(int id);
	
}
