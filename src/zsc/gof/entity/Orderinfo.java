package zsc.gof.entity;

import java.util.Date;

//预约表

public class Orderinfo {
	private int orderId;
	private Userinfo userinfo;
	private Premises premises;
	
	private Date orderTime;
	private int state;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Premises getPremises() {
		return premises;
	}
	public void setPremises(Premises premises) {
		this.premises = premises;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
