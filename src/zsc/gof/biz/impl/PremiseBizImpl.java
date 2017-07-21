package zsc.gof.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import zsc.gof.biz.PremiseBiz;
import zsc.gof.dao.PremisesDao;
import zsc.gof.entity.Premises;

@Service
public class PremiseBizImpl implements PremiseBiz {

	@Autowired 
	PremisesDao dao;
	
	@Override
	public List<Premises> find(Map map) {
		// TODO Auto-generated method stub
		List<Premises> list = dao.search(map);
		/*for(int i =0;i<list.size();i++){
			System.out.println(list.get(i).getPremisetype().getTypeName());
			System.out.println(list.get(i).getRegion().getRegionName());
			System.out.println(i);
		}*/
		System.out.println("--------biz-----------");
		System.out.println("cityId"+map.get("cityId"));
		System.out.println("min"+map.get("min"));
		System.out.println("max"+map.get("max"));
		System.out.println("regionId"+map.get("regionId"));
		System.out.println("housetype"+map.get("housetype"));
		System.out.println("buildType"+map.get("buildType"));
		System.out.println("keyword"+map.get("keyword"));
		System.out.println("pageIndex"+map.get("pageIndex"));
		System.out.println("pageSize"+map.get("pageSize"));
		System.out.println("listSize:"+list.size());
		System.out.println("--------biz-----------");
		return dao.search(map);
	}

	@Override
	public int addPremise(Premises premises) {
		// TODO Auto-generated method stub
		dao.insertPremises(premises);
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
		return dao.queryTotalRecord(map);
	}

	@Override
	public Premises findOne(int buildId) {
		// TODO Auto-generated method stub
		
		return dao.queryPremisesByBuildId(buildId);
	}
	
	@Override
	public int avgPremisePrice(int buildId) {
		Integer avgPrice = dao.queryAvgPremisesByBuildId(buildId);
		return avgPrice != null ? avgPrice : 0;
	}
}
