package com.sfp.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	//专辑发行时间
	private Date time;
	private String image;
	//歌手id
	private Integer aid;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the aid
	 */
	public Integer getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", time=" + time + ", image=" + image + ", aid=" + aid + "]";
	}
	
	
}
