package com.xjm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjm.entity.User;


public interface UserDao {
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(Integer id);
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User findUser(User user);
	/**
	 * 模糊查询   	分页
	 * @param queryname 用户名
	 * @param queryUserRole	角色
	 * @param pageIndex	当前页
	 * @param pageSize	个数
	 * @return
	 */
	public List<User> getUserList(@Param("queryname")String queryname,@Param("queryUserRole")Integer queryUserRole,
			@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	/**
	 * 模糊查询总行数
	 * @param queryname
	 * @param queryUserRole
	 * @return
	 */
	public Integer getUserCount(@Param("queryname")String queryname,@Param("queryUserRole")Integer queryUserRole);
	
}
