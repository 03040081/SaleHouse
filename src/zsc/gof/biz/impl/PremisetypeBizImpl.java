package zsc.gof.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.PremiseBiz;
import zsc.gof.biz.PremisetypeBiz;
import zsc.gof.dao.PremisetypeDao;
import zsc.gof.entity.Premises;
import zsc.gof.entity.Premisetype;

@Service
public class PremisetypeBizImpl implements PremisetypeBiz {

	@Autowired
	PremisetypeDao premisetypeDao;
	
	@Override
	public List<Premisetype> listPremisetypes() {
		// TODO Auto-generated method stub
		return premisetypeDao.queryPremisetypeList();
	}

	@Override
	public int addPremisetype(Premisetype premisetype) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePremisetype(Premisetype premisetype) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePremisetype(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
