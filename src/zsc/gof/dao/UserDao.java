package zsc.gof.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zsc.gof.entity.Userinfo;

public interface UserDao {
	
	
	
	/** 
	 * 更新用户信息
	 * @author lewis
	 * @param 用户对象
	 * @return 数据库影响的行数
	 * */
	@Update("UPDATE userinfo SET username = #{username},password = #{password},locked = #{locked},faceing = #{faceing},role = #{role.roleId} WHERE userId = #{userId}")
	public int updateInfo(Userinfo userinfo);
	
	
	/**
	 * 注册用户信息
	 * @author lewis
	 * @param 用户对象
	 * @return 数据库影响的行数
	 * */
	@Insert("INSERT INTO userinfo(username,password,locked,faceing,role) VALUES(#{username},#{password},#{locked},#{faceing},#{role.roleId})")
	public int register(Userinfo userinfo);
	
	/**
	 * 查询用户信息
	 * @author lewis
	 * @param 用户对象
	 * @return 数据库查询到的行数
	 * */
	@Select("SELECT count(userId) FROM userinfo AS u WHERE u.password = #{password} AND u.username = #{username} ")
	public int login(Userinfo userinfo); 
	
	
}
