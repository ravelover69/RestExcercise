package com.rest.excercise.domain.entities;

public class Item {
	
	public Item() {
		super();
	}
	int quantity;
	String unit;
	
	public Item(int quantity, String unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	

}
