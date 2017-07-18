package zsc.gof.biz;

import java.util.List;

import javax.management.relation.RoleInfo;


public interface RoleInfoBiz {
	
	public List<RoleInfo> listRoleInfos();
	
	public int addRoleInfo(RoleInfo roleInfo);
	
	public int deleteRoleInfo(int id);
	
	public int updateRoleInfo(RoleInfo roleInfo);
}
