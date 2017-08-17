package com.rest.excercise.domain;

import com.rest.excercise.domain.entities.MarketPlace;
import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Notice.Type;
import com.rest.excercise.domain.entities.Payload;
import com.rest.excercise.domain.entities.User;

public class UserAccount {
	MarketPlace marketPlace;
	User creator;
	User user;
	Payload payload;
	
	
	public UserAccount(MarketPlace marketPlace, User creator, User user, Payload payload) {
		super();
		this.marketPlace = marketPlace;
		this.creator = creator;
		this.user = user;
		this.payload = payload;
	}
	
	public UserAccount() {
		super();
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
