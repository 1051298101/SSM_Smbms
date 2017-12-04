package com.xjm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjm.dao.RoleDao;
import com.xjm.entity.Role;
import com.xjm.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findRoles() {
		return roleDao.findRoles();
	}

	@Override
	public int findRoleByCode(String roleCode) {
		// TODO Auto-generated method stub
		return roleDao.findRoleByCode(roleCode);
	}

	@Override
	public Role findRoleById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.findRoleById(id);
	}

	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.addRole(role);
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.updateRole(role);
	}

	@Override
	public int deleteRole(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.deleteRole(id);
	}

}
