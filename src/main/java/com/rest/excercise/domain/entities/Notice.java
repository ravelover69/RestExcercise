package com.rest.excercise.domain.entities;


public class Notice {
	
	
	public Notice() {
		super();
	}

	public Type type;
	
	public Notice(Type type) {
		super();
		this.type = type;
	}

	
	public enum Type {
        SUBSCRIPTION_ORDER,
        SUBSCRIPTION_CHANGE,
        SUBSCRIPTION_CANCEL,
        SUBSCRIPTION_NOTICE,
        DEACTIVATED,
        REACTIVATED,
        CLOSED,
        UPCOMMING_INVOICE,
        USER_ASSIGNMENT,
        USER_UNASSIGNMENT,
        USER_UPDATED
    }

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
