package zsc.gof.entity;

import java.util.List;

public class House {
	private int buildId; 	
	private int houseId;
	private String houseDesc;
	private double houseArea;
	private double housePrice;
	private int state;
	private Housetype housetype;
	private List<HouseImg> houseimg;
	
	public int getBuildId() {
		return buildId;
	}
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
	public String getHouseDesc() {
		return houseDesc;
	}
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}
	public List<HouseImg> getHouseimg() {
		return houseimg;
	}
	public void setHouseimg(List<HouseImg> houseimg) {
		this.houseimg = houseimg;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
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
}
