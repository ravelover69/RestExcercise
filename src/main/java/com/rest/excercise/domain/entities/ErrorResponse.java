package com.rest.excercise.domain.entities;

public class ErrorResponse extends Response {
	
	ErrorCode errorCode;
	
	public ErrorResponse(ErrorCode errorCode, String message) {
		super(false, message);
		this.errorCode = errorCode;
	}

	public ErrorResponse(ErrorCode errorCode) {
		super(false);
		this.errorCode = errorCode;
	}
	
	public ErrorResponse() {
		super(false);
	}


	 public enum ErrorCode {
	        USER_ALREADY_EXISTS,
	        USER_NOT_FOUND,
	        ACCOUNT_NOT_FOUND,
	        MAX_USERS_REACHED,
	        UNAUTHORIZED,
	        OPERATION_CANCELED,
	        CONFIGURATION_ERROR,
	        INVALID_RESPONSE,
	        PENDING,
	        FORBIDDEN,
	        BINDING_NOT_FOUND,
	        TRANSPORT_ERROR,
	        UNKNOWN_ERROR
	    }

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
