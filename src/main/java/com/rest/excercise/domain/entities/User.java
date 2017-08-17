package com.rest.excercise.domain.entities;

public class User {

	public User() {
		super();
	}

	String email;
	String firstName;
	String lastName;
	String lang;
	String locale;
	String openId;
	String uuid;
	Address adress;
	
	public User(String email, String firstName, String lastName, String lang, String locale, String openId, String uuid,
			Address address) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lang = lang;
		this.locale = locale;
		this.openId = openId;
		this.uuid = uuid;
		this.adress = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
}
