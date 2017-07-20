package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.HouseImg;

public interface HouseimgBiz {
	
	public List<HouseImg> listHouseImgs(int houseId);
	
	public void addHouseImgs(HouseImg houseImg);
	
	public void updateHouseImgs(HouseImg houseImg);
	
	public void deleteHouseImg(int imgId);
}
