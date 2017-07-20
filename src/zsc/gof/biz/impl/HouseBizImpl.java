package zsc.gof.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.HouseBiz;
import zsc.gof.dao.HouseDao;
import zsc.gof.entity.House;

@Service
public class HouseBizImpl implements HouseBiz {

	@Autowired
	HouseDao houseDao;
	
	@Override
	public List<House> listHouse(int buildId) {
		// TODO Auto-generated method stub
		return houseDao.queryHouseByBuildId(buildId);
	}

	@Override
	public int addHouse(House house) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHouse(House house) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteHouse(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
