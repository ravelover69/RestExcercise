package com.rest.excercise.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import com.rest.excercise.domain.Subscription;
import com.rest.excercise.domain.SubscriptionNotification;
import com.rest.excercise.domain.entities.ErrorResponse;
import com.rest.excercise.domain.entities.ErrorResponse.ErrorCode;
import com.rest.excercise.domain.entities.Response;
import com.rest.excercise.domain.entities.SuccessResponse;


@Service
public class SubscriptionService {

	private Map <String, Subscription> subscriptionMap;
	private static AtomicLong accountId = new AtomicLong();
	
	public SubscriptionService () 
	{
		subscriptionMap = new HashMap <String, Subscription>();
	}
	
	public Map<String, Subscription> getSubscriptionMap() {
		return subscriptionMap;
	}
	
	public static String createID()
	{
	    return String.valueOf(accountId.getAndIncrement());
	}
	
	
	public Response createSubscription (SubscriptionNotification newSubscription)
	{
		String acctId = createID ();
		
		subscriptionMap.put(acctId, newSubscription.getSubscription());
		return new SuccessResponse(acctId);
	}
	
	
	/*
	 * Change Subscription
	 */
	public Response changeSubscription (SubscriptionNotification newSubscription)
	{
		String acctIdentifier = newSubscription.getSubscription().getPayload().getAccount().getAccountIndetifier();
		Subscription subToReplace = subscriptionMap.remove(acctIdentifier);
		Response response;
		if (subToReplace == null) {
			response = new ErrorResponse(ErrorCode.USER_NOT_FOUND,"User Account Not Found");
		}
		else {
			subscriptionMap.put(acctIdentifier, newSubscription.getSubscription());
			response = new SuccessResponse(acctIdentifier, "Subscription Updated");
		}
		return response;
		
	}
	
	/*
	 * Cancel Subscription
	 */
	public Response cancelSubscription (SubscriptionNotification newSubscription)
	{
		String acctIdentifier = newSubscription.getSubscription().getPayload().getAccount().getAccountIndetifier();
		Subscription subToReplace = subscriptionMap.remove(acctIdentifier);
		Response response;
		if (subToReplace == null) {
			response = new ErrorResponse(ErrorCode.USER_NOT_FOUND,"User Account Not Found");
		}
		else {
			response = new SuccessResponse(acctIdentifier, "Subscription Cancelled");
		}
		return response;
		
	}
	
	
	/*
	 * Return all the subscription
	 */
	public Map <String, Subscription> getAllSubscription () {
		return subscriptionMap;
	}
	 
	public SuccessResponse notifySubscription (SubscriptionNotification newSubscription)
	{
		return new SuccessResponse(newSubscription.getSubscription().getPayload().getAccount().getAccountIndetifier());
		
	}

	
}
