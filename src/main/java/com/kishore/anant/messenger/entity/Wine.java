/**
 * 
 */
package com.kishore.anant.messenger.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author i351596
 *
 */
@XmlRootElement
public class Wine {

	public static final String COUNTRY = "country";
	public static final String DESCRIPTION = "description";
	public static final String DESIGNATION = "designation";
	public static final String POINTS = "points";
	public static final String PRICE = "price";
	public static final String PROVINCE = "province";
	public static final String REGION_1 = "region_1";
	public static final String REGION_2 = "region_2";
	public static final String VARIETY = "variety";
	public static final String WINERY = "winery";
	public static final String ID = "ID";
	public static final Object OBJECT_ID = "_id";

	private String oID;
	private String id;
	private String country;
	private String description;
	private String designation;
	private String points;
	private String price;
	private String province;
	private String region_1;
	private String region_2;
	private String variety;
	private String winery;

	/**
	 * 
	 */
	public Wine() {
		// TODO Auto-generated constructor stub
	}

	public Wine(String id, String country, String description, String designation, String points, String price,
			String province, String region_1, String region_2, String variety, String winery) {
		super();
		this.id = id;
		this.country = country;
		this.description = description;
		this.designation = designation;
		this.points = points;
		this.price = price;
		this.province = province;
		this.region_1 = region_1;
		this.region_2 = region_2;
		this.variety = variety;
		this.winery = winery;
	}
	
	public String getoID() {
		return oID;
	}

	public void setoID(String oID) {
		this.oID = oID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion_1() {
		return region_1;
	}

	public void setRegion_1(String region_1) {
		this.region_1 = region_1;
	}

	public String getRegion_2() {
		return region_2;
	}

	public void setRegion_2(String region_2) {
		this.region_2 = region_2;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getWinery() {
		return winery;
	}

	public void setWinery(String winery) {
		this.winery = winery;
	}

}
