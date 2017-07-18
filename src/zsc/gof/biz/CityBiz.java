package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.City;

public interface CityBiz {
	/*
	 * 搜索
	 * 城市列表
	 */
	public List<City> listCityById(int id);
	/*
	 * 
	 */
	//public City queryCityById(int id);
	/*
	 * 添加城市
	 */
	public int addCity(City city);
	
	public int updateCity(City city);
	
	public int deleteCity(int id);
}