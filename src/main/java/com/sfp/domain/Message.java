package com.sfp.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//发送者id
	private Integer uid;
	//接收者id
	private Integer rid;
	private String content;
	private Date time;
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
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
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
		return "Message [id=" + id + ", uid=" + uid + ", rid=" + rid + ", content=" + content + ", time=" + time + "]";
	}
	
}
