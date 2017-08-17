package com.rest.excercise.domain.entities;

public class Response {
	
	public Response() {
		super();
	}

	boolean success;
	
	public Response(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
