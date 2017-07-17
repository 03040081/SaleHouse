package zsc.gof.entity;

public class House {
	private int houseId;
	private String houseName;
	//private int houseType;
	private double houseArea;
	private double housePrice;
	private double downPay;
	private double monthPay;
	//private int buildId;
	private int state;
	
	private Housetype housetype;
	private Premises premises;//楼盘
	private HouseImg houseimg;
	
	public HouseImg getHouseimg() {
		return houseimg;
	}
	public void setHouseimg(HouseImg houseimg) {
		this.houseimg = houseimg;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public double getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(double houseArea) {
		this.houseArea = houseArea;
	}
	public double getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(double housePrice) {
		this.housePrice = housePrice;
	}
	public double getDownPay() {
		return downPay;
	}
	public void setDownPay(double downPay) {
		this.downPay = downPay;
	}
	public double getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(double monthPay) {
		this.monthPay = monthPay;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Housetype getHousetype() {
		return housetype;
	}
	public void setHousetype(Housetype housetype) {
		this.housetype = housetype;
	}
	public Premises getPremises() {
		return premises;
	}
	public void setPremises(Premises premises) {
		this.premises = premises;
	}
	
	
}
