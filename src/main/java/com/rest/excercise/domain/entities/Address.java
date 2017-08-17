package com.rest.excercise.domain.entities;

public class Address {

	public Address() {
		super();
	}
	String city;
	String country;
	String state;
	String street;
	String zip;
	
	public Address(String city, String country, String state, String street, String zip) {
		super();
		this.city = city;
		this.country = country;
		this.state = state;
		this.street = street;
		this.zip = zip;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}