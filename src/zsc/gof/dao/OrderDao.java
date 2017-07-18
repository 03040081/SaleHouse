package zsc.gof.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Orderinfo;

public interface OrderDao {
	
	/**
	 * @author lewis
	 * @param 订单对象
	 * @return 插入订单对象
	 * */
	@Insert("INSERT INTO orderinfo(userId,buildId,orderTime,state) VALUES(#{userinfo.userId},#{premises.buildId},#{orderTime},#{state})")
	public void insertOrder(Orderinfo orderinfo);
	
	
	/**
	 * @author lewis
	 * @param 根据用户id查询订单信息
	 * @return 返回订单信息列表
	 * */
	public List<Orderinfo> queryOrderinfoByUserId(int id);
}
