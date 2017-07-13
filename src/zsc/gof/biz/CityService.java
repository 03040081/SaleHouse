package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.City;

public interface CityService {
	public List<City> queryCity();
	public City queryCityById(int id);
}
