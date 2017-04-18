package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="b_users")
/**
 * 用户表
 * id:主键
 * userName:用户名
 * password:密码
 * level:等级，0最高
 * orderWeibo:订阅微博
 * recommend:�Ƽ�΢��
 * 
 * @author WangYang
 * 
 */
public class User {
	
	private int id;
	private String userName;
	private String password;
	private int level;
	private String orderWeibo;
	private String recommend;
	
	
	public User() {
		super();
	}
	
	public User(String userName, String password, int level) {
		super();
		this.userName = userName;
		this.password = password;
		this.level = level;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getOrderWeibo() {
		return orderWeibo;
	}
	public void setOrderWeibo(String orderWeibo) {
		this.orderWeibo = orderWeibo;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", level=" + level + ", orderWeibo=" + orderWeibo
				+ ", recommend=" + recommend + "]";
	}
	
}
