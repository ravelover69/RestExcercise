package com.rest.excercise.domain.entities;

public class Company {

	public Company() {
		super();
	}

	String country;
	String name;
	long phoneNumber;
	String uuid;
	String website;
	
	public Company(String country, String name, long phoneNumber, String uuid, String website) {
		super();
		this.country = country;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.uuid = uuid;
		this.website = website;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
}
