package com.xjm.dao;

import java.util.List;

import com.xjm.entity.Role;

public interface RoleDao {
	
	/**
	 *查询所有角色 
	 * @return
	 */
	public List<Role> findRoles();
	
	/**
	 * 查询编码是否存在
	 * @param roleCode
	 * @return
	 */
	public int findRoleByCode(String roleCode);
	
	/**
	 * 根据Id 查询角色
	 * @param id
	 * @return
	 */
	public Role findRoleById(Integer id);
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	public int addRole(Role role);
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public int updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	public int deleteRole(Integer id);
	
	
}
