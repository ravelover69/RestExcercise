package com.rest.excercise.domain;

import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Notice.Type;

public class UserAccountNotification {
	
	Notice.Type subscriptType;
	UserAccount userAccount;
	
	public UserAccountNotification() {
		super();
	}
	public UserAccountNotification(Type subscriptType, UserAccount userAccount) {
		super();
		this.subscriptType = subscriptType;
		this.userAccount = userAccount;
	}
	
	public Notice.Type getSubscriptType() {
		return subscriptType;
	}
	public void setSubscriptType(Notice.Type subscriptType) {
		this.subscriptType = subscriptType;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}
