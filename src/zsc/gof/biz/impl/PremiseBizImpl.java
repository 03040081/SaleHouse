package zsc.gof.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.PremiseBiz;
import zsc.gof.dao.PremisesDao;
import zsc.gof.entity.Premises;

@Service
public class PremiseBizImpl implements PremiseBiz {

	@Autowired 
	PremisesDao premisesDao;
	
	@Override
	public List<Premises> find(Map map) {
		// TODO Auto-generated method stub
		
		return premisesDao.search(map);
	}
	
}
