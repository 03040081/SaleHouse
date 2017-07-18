package zsc.gof.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zsc.gof.entity.Userinfo;
/**
 * @author lewis
 *	用户数据访问层
 */
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
	 * @return 数据库查询到的对象
	 * */

	@Select("SELECT * FROM userinfo AS u WHERE u.password = #{password} AND u.username = #{username} ")
	@Results({
		@Result(id=true,column="userId",property="userId"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="locked",property="locked"),
		@Result(column="faceing",property="faceing"),
		@Result(column="role",property="role",
		one=@One(select="zsc.gof.dao.RoleDao.queryRoleByRoleId")),
	})
	public Userinfo login(Userinfo userinfo); 
	
	
	/**
	 * @author lewis
	 * @param 用户id
	 * @return 返回对应id的用户
	 * */
	@Select("SELECT * FROM userinfo AS u WHERE u.userId = #{id}")
	@Results({
		@Result(id=true,column="userId",property="userId"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="locked",property="locked"),
		@Result(column="faceing",property="faceing"),
		@Result(column="role",property="role",
		one=@One(select="zsc.gof.dao.RoleDao.queryRoleByRoleId")),
	})
	public Userinfo queryUserInfoByUserId(int userId);
}
