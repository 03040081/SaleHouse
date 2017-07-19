package zsc.gof.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.UserInfoBiz;
import zsc.gof.dao.UserDao;
import zsc.gof.entity.Userinfo;

@Service
public class UserInfoBizImpl implements UserInfoBiz {

	@Autowired UserDao dao;
	
	@Override
	public Userinfo login(String username, String password) {
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername(username);
		userinfo.setPassword(password);
		return dao.login(userinfo);
	}

	@Override
	public int register(Userinfo userinfo) {
		return dao.register(userinfo);
	}

	@Override
	public int update(Userinfo userinfo) {
		return dao.updateInfo(userinfo);
	}

	@Override
	public int judgeUser(String username) {
		return dao.queryUserExist(username);
	}

}
