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
public class Message {
	
	public static final String MESSAGE_ID = "id";
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_CREATED_DATE = "createdDate";
	public static final String MESSAGE_AUTHOR = "author";

	private long id;
	private String text;
	private Date createdDate;
	private String author;

	/**
	 * 
	 */
	public Message() {
	
	}
	
	public Message(long id, String text, Date createdDate, String author) {
		super();
		this.id = id;
		this.text = text;
		this.createdDate = createdDate;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
