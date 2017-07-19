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

	@Override
	public int addPremise(Premises premises) {
		// TODO Auto-generated method stub
		premisesDao.insertPremises(premises);
		return 0;
	}

	@Override
	public int updatePremises(Premises premises) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePremises(int buildId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalPremises(Map map) {
		// TODO Auto-generated method stub
		return premisesDao.queryTotalRecord(map);
	}

	@Override
	public Premises findOne(int buildId) {
		// TODO Auto-generated method stub
		
		return premisesDao.queryPremisesByBuildId(buildId);
	}
	
}
