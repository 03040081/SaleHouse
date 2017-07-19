package zsc.gof.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.HouseBiz;
import zsc.gof.biz.HousetypeBiz;
import zsc.gof.dao.HouseTypeDao;
import zsc.gof.entity.House;
import zsc.gof.entity.Housetype;

@Service
public class HousetypeBizImpl implements HousetypeBiz {

	@Autowired
	HouseTypeDao houseTypeDao;
	
	@Override
	public List<Housetype> listHousetypes() {
		// TODO Auto-generated method stub
		return houseTypeDao.queryHouseTypeList();
	}

	@Override
	public int updateHousetype(Housetype house) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addHousetype(Housetype house) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteHousetype(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
