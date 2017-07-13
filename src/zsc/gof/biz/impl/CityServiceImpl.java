package zsc.gof.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.CityService;
import zsc.gof.dao.CityDao;
import zsc.gof.entity.City;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	CityDao cityDao;
	

	@Override
	public List<City> queryCity() {
		return cityDao.queryCity();
	}


	@Override
	public City queryCityById(int id) {
		return cityDao.quertCityById(id);
	}

}
