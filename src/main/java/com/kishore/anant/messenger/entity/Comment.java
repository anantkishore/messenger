/**
 * 
 */
package com.kishore.anant.messenger.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author i351596
 *
 */
@XmlRootElement
public class Comment {
	
	public static final String COMMENT_ID = "id";
	public static final String COMMENT_TEXT = "text";
	public static final String COMMENT_CREATED_DATE = "createdDate";
	public static final String COMMENT_OWNER = "author";

	private String id;
	private String oId;
	private String text;
	private Date createdDate;
	private String author;

	/**
	 * 
	 */
	public Comment() {
	
	}
	
	public Comment(String id, String text, Date createdDate, String author) {
		super();
		this.id = id;
		this.text = text;
		this.createdDate = createdDate;
		this.author = author;
	}
	
	public Comment(String id, String oIDParam, String text, Date createdDate, String author) {
		super();
		this.id = id;
		this.oId = oIDParam;
		this.text = text;
		this.createdDate = createdDate;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
