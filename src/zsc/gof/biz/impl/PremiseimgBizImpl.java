package zsc.gof.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.PremiseimgBiz;
import zsc.gof.dao.PremisesimgDao;
import zsc.gof.entity.Premisesimg;
@Service
public class PremiseimgBizImpl implements PremiseimgBiz {

	@Autowired
	PremisesimgDao premisesimgDao;
	
	@Override
	public void addPremisimg(Premisesimg premisesimg) {
		// TODO Auto-generated method stub
		premisesimgDao.insertPremisesimg(premisesimg);
	}

	@Override
	public void updatePremisimg(Premisesimg premisesimg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePremisimg(int buildId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Premisesimg> listPremiseImg(int buildId) {
		// TODO Auto-generated method stub
		return null;
	}

}
