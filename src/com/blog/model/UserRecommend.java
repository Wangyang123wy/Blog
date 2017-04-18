package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="b_userRecommend")
/**
 * ֪ʶ����Ϣ��
 * id:����
 * uId:�û�id
 * relatedId:�����û�id
 * relatedVotes:����ϵ��
 * 
 * @author WangYang
 *
 */
public class UserRecommend {

	private int id;
	private int uId;
	private int relatedId;
	private int relatedVotes;
	
	public UserRecommend() {
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
	public int getRelatedId() {
		return relatedId;
	}
	public void setRelatedId(int relatedId) {
		this.relatedId = relatedId;
	}
	public int getRelatedVotes() {
		return relatedVotes;
	}
	public void setRelatedVotes(int relatedVotes) {
		this.relatedVotes = relatedVotes;
	}
	@Override
	public String toString() {
		return "UserRecommend [id=" + id + ", uId=" + uId + ", relatedId="
				+ relatedId + ", relatedVotes=" + relatedVotes + "]";
	}
	
}
