package com.blog.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.blog.model.User;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
	private String userName;
	private String password; // 密码
	
	// 修改密码
	private String currentpassword;
	private String newpassword;
	
	// 订阅查看 
	private String[] orderedBlogs;
	
	private int level;    // 权限值
	private int modifiedlevel;
	
	private String info;  // 错误信息
	
	private Map<String ,Object> session;
	
	private UserService userService;
	
	/**
	 * 更新password
	 * @return
	 */
	public String updatePassword(){
		String userName=(String)session.get("userName");
		boolean flag=userService.updatePassword(currentpassword,userName, newpassword);
		if(flag){
			info="成功修改密码";
		}else{
			info="修改密码失败";
		}
		return "updatePassword";
	}
	/**
	 * 注册
	 * @return
	 */
	public String register(){
		User user =new User(userName,password,1);
		boolean flag=userService.save(user);
		if(flag){
			info="注册成功";
		}else{
			info="注册失败";
		}
		return "register";
	}
	/**
	 *  登录
	 * @return
	 */
	public String login(){
		int level =userService.checkLogin(userName, password);
		if(-1!=level){
			session.put("userName",userName);
			session.put("level", level);
			return "home";
		}
		info="用户名或密码错误!";
		return "login";
	}
	/**
	 * 订阅查看
	 * @return
	 */
	public String subscribe(){
		String userName=(String)session.get("userName");
		orderedBlogs = userService.getOrderBlogs(userName);
		if(orderedBlogs!=null&&orderedBlogs.length>0){
			
		}else{
			info="null";
		}
		return "subscribe";
	}
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the modifiedlevel
	 */
	public int getModifiedlevel() {
		return modifiedlevel;
	}
	/**
	 * @param modifiedlevel the modifiedlevel to set
	 */
	public void setModifiedlevel(int modifiedlevel) {
		this.modifiedlevel = modifiedlevel;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCurrentpassword() {
		return currentpassword;
	}
	
	
	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	/**
	 * @return the orderedBlogs
	 */
	public String[] getOrderedBlogs() {
		return orderedBlogs;
	}
	/**
	 * @param orderedBlogs the orderedBlogs to set
	 */
	public void setOrderedBlogs(String[] orderedBlogs) {
		this.orderedBlogs = orderedBlogs;
	}
	
}