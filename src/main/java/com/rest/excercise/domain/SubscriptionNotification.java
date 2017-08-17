package com.rest.excercise.domain;


import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Notice.Type;


public class SubscriptionNotification {
	
	Notice.Type subscriptType;
	private Subscription subscription;
	
	
	public SubscriptionNotification() {
		super();
	}

	public SubscriptionNotification(Type subscriptType, Subscription subscription) {
		super();
		this.subscriptType = subscriptType;
		this.subscription = subscription;
	}

	public Notice.Type getSubscriptType() {
		return subscriptType;
	}

	public void setSubscriptType(Notice.Type subscriptType) {
		this.subscriptType = subscriptType;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	

}
