package com.xjm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjm.dao.UserDao;
import com.xjm.entity.User;
import com.xjm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

	@Override
	public User findUser(User user) {
		try {
			return userDao.findUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public int addUser(User user) {
	try {
			return userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateUser(User user) {
		try {
			return userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteUser(Integer id) {
		try {
			return userDao.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> getUserList(String queryname, Integer queryUserRole,
			Integer pageIndex, Integer pageSize) {
		
		return userDao.getUserList(queryname, queryUserRole, (pageIndex-1)*pageSize, pageSize);
	}

	@Override
	public Integer getUserCount(String queryname, Integer queryUserRole) {
		return userDao.getUserCount(queryname, queryUserRole);
	}

}
