package com.sfp.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//评论者id
	private Integer uid;
	//评论内容
	private String content;
	//评论时间
	private Date time;
	//点赞数
	private Integer likes;
	//评论的音乐
	private Integer mid;
	//评论的评论
	private Integer cid;
	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the like
	 */
	public Integer getLike() {
		return likes;
	}
	/**
	 * @param like the like to set
	 */
	public void setLike(Integer like) {
		this.likes = like;
	}
	/**
	 * @return the mid
	 */
	public Integer getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", uid=" + uid + ", content=" + content + ", time=" + time + ", like=" + likes
				+ ", mid=" + mid + ", cid=" + cid + "]";
	}
	
}
