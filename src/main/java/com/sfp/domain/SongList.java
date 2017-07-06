package com.sfp.domain;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songlist")
public class SongList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date time;
	//创建此歌单的用户id
	private Integer uid;
	private String image;
	private ArrayList<Music> songList;
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
	 * @return the songList
	 */
	public ArrayList<Music> getSongList() {
		return songList;
	}
	/**
	 * @param songList the songList to set
	 */
	public void setSongList(ArrayList<Music> songList) {
		this.songList = songList;
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
		return "SongList [id=" + id + ", name=" + name + ", time=" + time + ", uid=" + uid + ", image=" + image
				+ ", songList=" + songList + "]";
	}
	

}
