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
public class Profile {

	private long id;
	private String firstName;
	private String lastName;
	private String profileName;
	private Date createdDate;

	/**
	 * 
	 */
	public Profile() {
	}

	public Profile(long id, String firstName, String lastName, String profileName, Date createdDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileName = profileName;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
