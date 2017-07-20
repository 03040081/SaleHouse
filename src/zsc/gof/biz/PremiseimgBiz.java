package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.Premisesimg;

public interface PremiseimgBiz {
	
	public void addPremisimg(Premisesimg premisesimg);
	
	public void updatePremisimg(Premisesimg premisesimg);
	
	public void deletePremisimg(int buildId);
	
	public List<Premisesimg> listPremiseImg(int buildId);
}
