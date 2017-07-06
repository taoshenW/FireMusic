package com.sfp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "music")
public class Music {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer artist;
	private Integer count;
	private Integer language;
	private Integer type;
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
	 * @return the artist
	 */
	public Integer getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(Integer artist) {
		this.artist = artist;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @return the language
	 */
	public Integer getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Integer language) {
		this.language = language;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
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
		return "Music [id=" + id + ", name=" + name + ", artist=" + artist + ", count=" + count + ", language="
				+ language + ", type=" + type + "]";
	}
	
	
}
