package zsc.gof.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.CityBiz;
import zsc.gof.dao.CityDao;
import zsc.gof.entity.City;

@Service
public class CityBizImpl implements CityBiz{

	@Autowired
	CityDao cityDao;

	@Override
	public List<City> listCityById(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}


	@Override
	public int addCity(City city) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateCity(City city) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteCity(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<City> listCitys() {
		// TODO Auto-generated method stub
		return cityDao.queryCity();
	}

}
