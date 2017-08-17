package com.rest.excercise.domain.entities;

import java.util.ArrayList;

public class Order {

	public Order() {
		super();
	}
	String editionCode;
	String pricingDuration;
	ArrayList <Item> items;
	
	
	public Order(String editionCode, String pricingDuration, ArrayList<Item> items) {
		super();
		this.editionCode = editionCode;
		this.pricingDuration = pricingDuration;
		this.items = items;
	}
	
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
}
