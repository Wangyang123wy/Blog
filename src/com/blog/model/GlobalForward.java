package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="b_globalForward")
/**
 * 全局转发评论推荐表
 * id:主键
 * wId:微博id
 * 
 * @author WangYang
 *
 */
public class GlobalForward {
	
	private int id;
	private String wId;
	
	public GlobalForward() {
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
	public String getwId() {
		return wId;
	}
	public void setwId(String wId) {
		this.wId = wId;
	}
	@Override
	public String toString() {
		return "UserForward [id=" + id + ", wId=" + wId + "]";
	}
	
}
