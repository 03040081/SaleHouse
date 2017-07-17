package zsc.gof.dao;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.Role;

public interface RoleDao {
	/**
	 * @author lewis
	 * @param 角色id
	 * @return 返回角色对象
	 * */
	@Select("SELECT * FROM roleinfo AS r WHERE r.roleId = #{id}")
	public Role queryRoleByRoleId(int id);
}
