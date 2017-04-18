package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="b_globalKeyWords")
/**
 * 关键字排名表
 * id:主键
 * keyWord:关键字
 * index:排名
 * time:时间
 * 
 * @author WangYang
 *
 */
public class GlobalKeyWord {

	private int id;
	private String keyWord;
	private int index;
	private Date time;
	
	public GlobalKeyWord() {
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
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "GlobalKeyWord [id=" + id + ", keyWord=" + keyWord + ", index="
				+ index + ", time=" + time + "]";
	}
	
}
