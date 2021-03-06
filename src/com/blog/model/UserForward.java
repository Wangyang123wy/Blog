package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="b_userForward")
/**
 * 用户转发推荐表
 * id:主键
 * uId:用户id
 * wId:微博id
 * 
 * @author WangYang
 *
 */
public class UserForward {
	
	private int id;
	private int uId;
	private String wId;
	
	public UserForward() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getwId() {
		return wId;
	}
	public void setwId(String wId) {
		this.wId = wId;
	}
	@Override
	public String toString() {
		return "UserForward [id=" + id + ", uId=" + uId + ", wId=" + wId + "]";
	}
	
}
