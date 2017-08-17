package com.rest.excercise.domain;

import com.rest.excercise.domain.entities.MarketPlace;
import com.rest.excercise.domain.entities.Payload;
import com.rest.excercise.domain.entities.User;

public class Subscription {
	
	
	MarketPlace marketPlace;
	User creator;
	Payload payload;
	
	
	public Subscription() {
		super();
	}
	public Subscription(MarketPlace marketPlace, User creator, Payload payload) {
		super();
		this.marketPlace = marketPlace;
		this.creator = creator;
		this.payload = payload;
	}
	
	public MarketPlace getMarketPlace() {
		return marketPlace;
	}
	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}

}
