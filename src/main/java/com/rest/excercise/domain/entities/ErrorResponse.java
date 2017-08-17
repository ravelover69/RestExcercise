package com.rest.excercise.domain.entities;

public class ErrorResponse extends Response {
	
	public ErrorResponse(boolean success) {
		super(success);
	}

	ErrorCode errorCode;
	String message;
	String userIdentifier;
	String accountIdentifier;
	
	public ErrorResponse(ErrorCode errorCode, String message, String userIdentifier,
			String accountIdentifier) {
		super(false);
		this.errorCode = errorCode;
		this.message = message;
		this.userIdentifier = userIdentifier;
		this.accountIdentifier = accountIdentifier;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
}
