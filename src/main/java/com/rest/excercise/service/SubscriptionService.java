package com.rest.excercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.excercise.domain.Subscription;
import com.rest.excercise.domain.SubscriptionNotification;
import com.rest.excercise.domain.entities.Account;
import com.rest.excercise.domain.entities.Address;
import com.rest.excercise.domain.entities.Company;
import com.rest.excercise.domain.entities.Item;
import com.rest.excercise.domain.entities.MarketPlace;
import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Order;
import com.rest.excercise.domain.entities.Payload;
import com.rest.excercise.domain.entities.SuccessResponse;
import com.rest.excercise.domain.entities.User;

@Service
public class SubscriptionService {

	private static List <Subscription> subscriptionList;
	
	public SuccessResponse createSubscription (SubscriptionNotification newSubscription)
	{
		
		
		return new SuccessResponse("123");
		
	}
	
	public SuccessResponse changeSubscription (SubscriptionNotification newSubscription)
	{
		return new SuccessResponse("123");
		
	}
	
	
	public SuccessResponse cancelSubscription (SubscriptionNotification newSubscription)
	{
		//System.out.println ("Deleting " + acctId);
		return new SuccessResponse(newSubscription.getSubscription().getPayload().getAccount().getAccountIndetifier());
		
	}
	
	public SuccessResponse notifySubscription (SubscriptionNotification newSubscription)
	{
		return new SuccessResponse("123");
		
	}
	
	private static void populateSubscription () {
		
		subscriptionList = new ArrayList <Subscription> ();
		
		MarketPlace marketPlace = new MarketPlace("https://www.acme.com", "APPDIRECT");
		Address address = new Address("San Jose", "US", "CA", "1 Main St", "95131");
		User creator = new User("testuser@testco.com", "Test", "User", "en", "en-US", "https://www.acme.com/openid/id/47cb8f55-1af6-5bfc-9a7d-8061d3aa0c97", "47cb8f55-1af6-5bfc-9a7d-8061d3aa0c97", address);
		Company company = new Company("US", "tester", 1-800-333-3333, "385beb51-51ae-4ffe-8c05-3f35a9f99825", "");
		ArrayList <Item> items = new ArrayList<Item>(1);
		items.add(new Item (4, "USER"));
	    Order order = new Order("Standard", "MONTHLY", items);    
	    Payload payLoad = new Payload(null, null, company, order, null);			
	    Subscription sub = new Subscription (marketPlace, creator, payLoad);
		subscriptionList.add(sub);
		
	}
	
	
	
}
