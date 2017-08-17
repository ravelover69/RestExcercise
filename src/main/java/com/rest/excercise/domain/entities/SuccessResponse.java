package com.rest.excercise.domain.entities;


public class SuccessResponse extends Response {
	
	String indentifier;

	public SuccessResponse() {
		super(true);
	}

	public SuccessResponse(String indentifier) {
		super(true);
		this.indentifier = indentifier;
	}
	
	public SuccessResponse(String indentifier, String message) {
		super(true, message);
		this.indentifier = indentifier;
	}

	
	public String getAccountIndentifier() {
		return indentifier;
	}

	public void setAccountIndentifier(String indentifier) {
		this.indentifier = indentifier;
	}

	
	

}
