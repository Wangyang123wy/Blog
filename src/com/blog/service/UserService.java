package com.blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.UserDao;
import com.blog.model.User;

@Component("userService")
public class UserService {
	private UserDao userDao;
	
	@Transactional
	public String[] getOrderBlogs(String userName){
		return userDao.getOrder(userName);
	}
	
	@Transactional
	public boolean addOrderBlog(String userName,String blogId){
		return userDao.addOrder(userName, blogId);
	}
	
	@Transactional
	public boolean deleteOrderBlog(String userName,String blogId){
		return userDao.deleteOrder(userName, blogId);
	}
	
	@Transactional
	public boolean save(User user){
		if(this.userDao.check(user.getUserName())){
			return false;
		}
		this.userDao.add(user);
		
		return true;
	}
	
	public void delete(User user){
		this.userDao.delete(user);
	}
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@Transactional
	public List<User> getUsers(int currentPage, int pageSize) {
		
		return this.userDao.getUsers(currentPage,pageSize);
	}
	
	public int getTotalPage(){
		return this.userDao.getTotalPage();
	}
	
	@Transactional
	public int checkLogin(String userName,String password){
		String currPasswordReal=this.userDao.getPasswordByUserName(userName);
		if(currPasswordReal!=null){
			if(currPasswordReal.equals(password)){
				
				return this.userDao.getLevelByUserName(userName);
			}
		}
		return -1;
	}
	
	@Transactional
	public  boolean updatePassword(String currPassword,String userName,String newPassword){
		String currPasswordReal=this.userDao.getPasswordByUserName(userName);
		if(currPasswordReal!=null){
			if(!currPasswordReal.equals(currPassword)){
				return false;
			}
		}else{
			return false;
		}
		return this.userDao.modifyPasswordByUserName(userName, newPassword);
	}
	
	@Transactional
	public boolean updateLevel(String userName,int level){
		return this.userDao.modifyLevelByUserName(userName, level);
	}
	@Transactional
	public User getUser(String userName){
		return this.userDao.getUser(userName);
	}
}

