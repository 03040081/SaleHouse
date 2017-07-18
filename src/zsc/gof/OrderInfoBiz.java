package zsc.gof;

import java.util.List;

import zsc.gof.entity.Orderinfo;

public interface OrderInfoBiz {
	/*
	 * 通过用户id查看用户的预约状况
	 */
	public List<Orderinfo> listOI(int userId);
	
}
