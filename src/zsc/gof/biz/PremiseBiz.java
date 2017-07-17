package zsc.gof.biz;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.Premises;

public interface PremiseBiz {
	public List<Premises> find(Map map);
}
