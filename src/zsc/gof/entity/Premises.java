package zsc.gof.entity;

import java.util.List;

public class Premises {
	public String getInOpen() {
		return inOpen;
	}
	public void setInOpen(String inOpen) {
		this.inOpen = inOpen;
	}
	public String getInLive() {
		return inLive;
	}
	public void setInLive(String inLive) {
		this.inLive = inLive;
	}

	private int buildId;
	private String buildName;
	private String inOpen; 
	private String inLive;
	private int households;
	private String propertyRight;
	private String propertyCosts;
	private String buildArea;
	private String floorArea;
	private String buildAddress;
	//private int buildType;////////////////////////////////
	private String developer;
	//private int regionId;////////////////////
	private Premisetype premisetype;//buildType
	private Region region;
	private String iconUrl;
	private List<Premisesimg> premisesimg;
	private List<House> houses;
	private List<Premisesimg> premisesimgLesser;
	private List<Premisesimg> premisesimgBiggest;
	public List<Premisesimg> getPremisesimgLesser() {
		return premisesimgLesser;
	}
	public void setPremisesimgLesser(List<Premisesimg> premisesimgLesser) {
		this.premisesimgLesser = premisesimgLesser;
	}
	public List<Premisesimg> getPremisesimgBiggest() {
		return premisesimgBiggest;
	}
	public void setPremisesimgBiggest(List<Premisesimg> premisesimgBiggest) {
		this.premisesimgBiggest = premisesimgBiggest;
	}
	public List<House> getHouses() {
		return houses;
	}
	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	public String getPropertyRight() {
		return propertyRight;
	}
	public void setPropertyRight(String propertyRight) {
		this.propertyRight = propertyRight;
	}
	public String getBuildArea() {
		return buildArea;
	}
	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}
	public String getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}
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
	
	public int getHouseholds() {
		return households;
	}
	public void setHouseholds(int households) {
		this.households = households;
	}
	
	public String getPropertyCosts() {
		return propertyCosts;
	}
	public void setPropertyCosts(String propertyCosts) {
		this.propertyCosts = propertyCosts;
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
