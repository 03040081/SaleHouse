package zsc.gof.entity;

import java.util.Date;
import java.util.List;

public class Premises {
	private int buildId;
	private String buildName;
	private Date inOpen; 
	private Date inLive;
	private int households;
	private int propertyRight;
	private String propertyCosts;
	private double buildArea;
	private double floorArea;
	private String buildAddress;
	//private int buildType;////////////////////////////////
	private String developer;
	//private int regionId;////////////////////
	private Premisetype premisetype;//buildType
	private Region region;
	private String iconUrl;
	private List<Premisesimg> premisesimg;
	

	public List<Premisesimg> getPremisesimg() {
		return premisesimg;
	}
	public void setPremisesimg(List<Premisesimg> premisesimg) {
		this.premisesimg = premisesimg;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public int getBuildId() {
		return buildId;
	}
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public Date getInOpen() {
		return inOpen;
	}
	public void setInOpen(Date inOpen) {
		this.inOpen = inOpen;
	}
	public Date getInLive() {
		return inLive;
	}
	public void setInLive(Date inLive) {
		this.inLive = inLive;
	}
	public int getHouseholds() {
		return households;
	}
	public void setHouseholds(int households) {
		this.households = households;
	}
	public int getPropertyRight() {
		return propertyRight;
	}
	public void setPropertyRight(int propertyRight) {
		this.propertyRight = propertyRight;
	}
	public String getPropertyCosts() {
		return propertyCosts;
	}
	public void setPropertyCosts(String propertyCosts) {
		this.propertyCosts = propertyCosts;
	}
	public double getBuildArea() {
		return buildArea;
	}
	public void setBuildArea(double buildArea) {
		this.buildArea = buildArea;
	}
	public double getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(double floorArea) {
		this.floorArea = floorArea;
	}
	public String getBuildAddress() {
		return buildAddress;
	}
	public void setBuildAddress(String buildAddress) {
		this.buildAddress = buildAddress;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public Premisetype getPremisetype() {
		return premisetype;
	}
	public void setPremisetype(Premisetype premisetype) {
		this.premisetype = premisetype;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return "Premises [buildId=" + buildId + ", buildName=" + buildName + ", inOpen=" + inOpen + ", inLive=" + inLive
				+ ", households=" + households + ", propertyRight=" + propertyRight + ", propertyCosts=" + propertyCosts
				+ ", buildArea=" + buildArea + ", floorArea=" + floorArea + ", buildAddress=" + buildAddress
				+ ", developer=" + developer + ", premisetype=" + premisetype + ", region=" + region + ", iconUrl="
				+ iconUrl + "]";
	}
}
