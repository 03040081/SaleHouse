package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.Orderinfo;

public interface OrderinfoBiz {
	
	public List<Orderinfo> listOrder(int buildId);
}
