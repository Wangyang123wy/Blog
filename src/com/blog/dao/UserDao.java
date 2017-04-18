package com.blog.dao;

import java.util.List;

import com.blog.model.User;

public interface UserDao {

	/**
	 *  添加单个用户
	 * @param user
	 */
	public void add(User user);
	/**
	 * 删除单个用户
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * 检查是否含有用户
	 * @param userName
	 * @return
	 */
	public boolean check(String userName);

	/**
	 * 获得用户列表
	 * @param pageSize 
	 * @param currentPage 
	 * @return
	 */
	public List<User> getUsers(int currentPage, int pageSize);
	/**
	 * 用户列表所有记录数
	 * @return
	 */
	public int getTotalPage();
	/**
	 * 根据用户名修改密码
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean modifyPasswordByUserName(String userName,String password);
	/**
	 * 根据用户名获得用户密码
	 * @param userName
	 * @return
	 */
	public String getPasswordByUserName(String userName);
	/**
	 * 更加用户名获得用户权限
	 * @param userName
	 * @return
	 */
	public int getLevelByUserName(String userName);
	/**
	 * 根据用户名修改权限
	 * @param userName
	 * @param level
	 * @return
	 */
	public boolean modifyLevelByUserName(String userName,int level);
	/**
	 * 根据用户名获得用户实体
	 * @param userName
	 * @return
	 */
	public User getUser(String userName);
	/**
	 * 获得用户订阅博客列表
	 * @param userName
	 * @return
	 */
	public String[] getOrder(String userName);
	/**
	 * 添加订阅博客
	 * @param blogId
	 * @return
	 */
	public boolean addOrder(String userName,String blogId);
	/**
	 * 删除订阅博客
	 * @param blogId
	 * @return
	 */
	public boolean deleteOrder(String userName,String blogId);
	/**
	 * 添加用户推荐博客
	 * @param userName
	 * @param recommend
	 * @return
	 */
	public boolean insertRecommend(String userName,String recommend);
	/**
	 * 获得用户推荐博客
	 * @param userName
	 * @return
	 */
	public String[] getRecommend(String userName);
	/**
	 * 更新推荐
	 * @param userName
	 * @param recommend
	 * @return
	 */
	public boolean updateRecommend(String userName,String recommend);
}