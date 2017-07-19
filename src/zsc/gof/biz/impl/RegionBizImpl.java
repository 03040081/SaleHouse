package zsc.gof.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.RegionBiz;
import zsc.gof.dao.RegionDao;
import zsc.gof.entity.Region;

@Service
public class RegionBizImpl implements RegionBiz {

	@Autowired
	RegionDao regionDao;
	
	@Override
	public List<Region> listRegById(int id) {
		// TODO Auto-generated method stub
		return regionDao.queryReginonListByCityId(id);
	}

	@Override
	public int addRegion(Region region) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRegion(Region region) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRegion(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
