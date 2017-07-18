package zsc.gof.biz;

import zsc.gof.entity.Userinfo;

public interface UserInfoBiz {
	
	public Userinfo login(String username,String password);
	
	//public void logout();
	
	public int register(Userinfo userinfo);
	
	public int update(Userinfo userinfo); 
}
