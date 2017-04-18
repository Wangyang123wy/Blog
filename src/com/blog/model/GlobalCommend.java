package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="b_globalCommend")
/**
 * 全局评论推荐表
 * id:主键
 * wId:微博id
 * 
 * @author WangYang
 *
 */
public class GlobalCommend {
	
	private int id;
	private String wId;
	
	public GlobalCommend() {
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
