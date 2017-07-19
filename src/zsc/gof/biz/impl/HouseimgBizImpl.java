package zsc.gof.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.HouseimgBiz;
import zsc.gof.dao.HouseImgDao;
import zsc.gof.entity.HouseImg;
@Service
public class HouseimgBizImpl implements HouseimgBiz {

	@Autowired
	HouseImgDao houseImgDao;
	
	@Override
	public List<HouseImg> listHouseImgs(int houseId) {
		// TODO Auto-generated method stub
		return houseImgDao.queryHouseImgByHouseId(houseId);
	}

	@Override
	public void addHouseImgs(List<HouseImg> listHouseImgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHouseImgs(List<HouseImg> listHouseImgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHouseImg(int imgId) {
		// TODO Auto-generated method stub
		
	}

	

}
