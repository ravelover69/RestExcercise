package com.rest.excercise.domain.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Account {
	

	String accountIndetifier;
	String status;
	
	@Autowired
	public Account() {
		super();
	}
	
	
	public Account(String accountIndetifier, String status) {
		super();
		this.accountIndetifier = accountIndetifier;
		this.status = status;
	}
	
	public String getAccountIndetifier() {
		return accountIndetifier;
	}
	public void setAccountIndetifier(String accountIndetifier) {
		this.accountIndetifier = accountIndetifier;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
