package com.rest.excercise.domain.entities;


public class SuccessResponse extends Response {
	
	
	public SuccessResponse() {
		super();
	}

	String accountIndentifier;

	public SuccessResponse(String accountIndentifier) {
		super(true);
		this.accountIndentifier = accountIndentifier;
	}
	
	public String getAccountIndentifier() {
		return accountIndentifier;
	}

	public void setAccountIndentifier(String accountIndentifier) {
		this.accountIndentifier = accountIndentifier;
	}
	
	

}
