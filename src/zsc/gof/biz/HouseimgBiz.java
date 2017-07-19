package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.HouseImg;

public interface HouseimgBiz {
	
	public List<HouseImg> listHouseImgs(int houseId);
	
	public void addHouseImgs(List<HouseImg> listHouseImgs);
	
	public void updateHouseImgs(List<HouseImg> listHouseImgs);
	
	public void deleteHouseImg(int imgId);
}
