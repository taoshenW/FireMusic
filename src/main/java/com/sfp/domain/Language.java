package com.sfp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
		return "Language [id=" + id + ", title=" + title + "]";
	}
	
	
}
