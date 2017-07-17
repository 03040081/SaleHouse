package zsc.gof.dao;


import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Orderinfo;

public interface OrderDao {
	
	/**
	 * @author lewis
	 * @param 订单对象
	 * @return 插入订单对象
	 * */
	@Select("INSERT INTO orderinfo(userId,buildId,orderTime,state) VALUES(#{userinfo.userId},#{premises.buildId},#{orderTime},#{state})")
	public void insertOrder(Orderinfo orderinfo);
	
	
	
}
