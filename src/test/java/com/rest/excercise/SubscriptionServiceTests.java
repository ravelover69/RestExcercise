package com.rest.excercise;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.rest.excercise.domain.Subscription;
import com.rest.excercise.domain.SubscriptionNotification;
import com.rest.excercise.domain.UserAccount;
import com.rest.excercise.domain.UserAccountNotification;
import com.rest.excercise.domain.entities.Account;
import com.rest.excercise.domain.entities.Address;
import com.rest.excercise.domain.entities.Company;
import com.rest.excercise.domain.entities.Item;
import com.rest.excercise.domain.entities.MarketPlace;
import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Order;
import com.rest.excercise.domain.entities.Payload;
import com.rest.excercise.domain.entities.Response;
import com.rest.excercise.domain.entities.User;
import com.rest.excercise.service.SubscriptionService;
import com.rest.excercise.service.UserAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionServiceTests {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/sub";

	@Autowired
	public SubscriptionService subService;
	

	@Test
	public void testCreateSubscription() {
		
		MarketPlace marketPlace = new MarketPlace("https://www.acme.com", "APPDIRECT");
		Address address = new Address("San Jose", "US", "CA", "1 Main St", "95131");
		User creator = new User("testuser@testco.com", "Test", "User", "en", "en-US", "https://www.acme.com/openid/id/47cb8f55-1af6-5bfc-9a7d-8061d3aa0c97", "47cb8f55-1af6-5bfc-9a7d-8061d3aa0c97", address);
		Company company = new Company("US", "tester", 1-800-333-3333, "385beb51-51ae-4ffe-8c05-3f35a9f99825", "");
		ArrayList <Item> items = new ArrayList<Item>(1);
		items.add(new Item (4, "USER"));
	    Order order = new Order("Standard", "MONTHLY", items);    
	    Payload payLoad = new Payload(null, null, company, order, null, null);
	    Subscription sub = new Subscription (marketPlace, creator, payLoad);
		SubscriptionNotification subNotice = new SubscriptionNotification(Notice.Type.SUBSCRIPTION_ORDER, sub);
		Response response = subService.createSubscription(subNotice);
		assertThat (response.isSuccess(), is(true));
	}
	
	
	@Test
	public void testChangeSubscription() {
		
		MarketPlace marketPlace = new MarketPlace("https://www.acme.com", "APPDIRECT");
		Address address = new Address("San Jose", "US", "CA", "1 Main St.", "95131");
		User creator = new User("testuser@testco.com", "Test", "User", "en", "en-US", "https://www.acme.com/openid/id/7f59aad1-85cd-4c04-b35b-906ee53acc71", "7f59aad1-85cd-4c04-b35b-906ee53acc71", address);
		ArrayList <Item> items = new ArrayList<Item>(1);
		items.add(new Item (0, "GIGABYTE"));
	    Order order = new Order("DME", "DAILY", items);
	    Account account = new Account ("123", "ACTIVE");
	    Payload payLoad = new Payload(account, null, null, order, null, null);	
	    Subscription sub = new Subscription (marketPlace, creator, payLoad);
		SubscriptionNotification subNotice = new SubscriptionNotification(Notice.Type.SUBSCRIPTION_CHANGE, sub);
		Response response = subService.changeSubscription(subNotice);
		assertThat (response.isSuccess(), is(true));
	}
	

	@Test
	public void testCancelSubscription() {
		
		MarketPlace marketPlace = new MarketPlace("https://www.acme.com", "APPDIRECT");
		Address address = new Address("Somerville", "US", "MA", "55 Grove St.", "02144");
		User creator = new User("testuser@testco.com", "Test", "User", "en", "en-US", "https://www.acme.com/openid/id/d124bf8b-0b0b-40d3-831b-b7f5a514d487", "d124bf8b-0b0b-40d3-831b-b7f5a514d487", address);
		ArrayList <Item> items = new ArrayList<Item>(1);
		items.add(new Item (0, "GIGABYTE"));
	    Order order = new Order("DME", "DAILY", items);
	    Account account = new Account ("9d6fca98-aa94-462b-85fa-118804ad3fe3", "ACTIVE");
	    Payload payLoad = new Payload(account, null, null, order, null, null);			
	    Subscription sub = new Subscription (marketPlace, creator, payLoad);
	    SubscriptionNotification subNotice = new SubscriptionNotification(Notice.Type.SUBSCRIPTION_CANCEL, sub);
	    Response response = subService.cancelSubscription(subNotice);
	    assertThat (response.isSuccess(), is(true));
	}
	
	
	@Test
	public void testgetAllSubscription() {
		
		Map <String, Subscription> subMap = subService.getAllSubscription();
		for (Map.Entry<String, Subscription> entry : subMap.entrySet()) {
			System.out.println(entry.getValue().getMarketPlace().getBaseUrl());
		}
		assert (subMap.size() > 0);
	}

	
	@Test
	public void testNotify() {
		
		MarketPlace marketPlace = new MarketPlace("https://www.acme.com", "APPDIRECT");
	    Account account = new Account ("9d6fca98-aa94-462b-85fa-118804ad3fe3", "ACTIVE");
	    Notice notice = new Notice (Notice.Type.UPCOMMING_INVOICE);
	    Payload payLoad = new Payload(account, null, null, null, notice, null);			
	    Subscription sub = new Subscription (marketPlace, null, payLoad);
	    SubscriptionNotification subNotice = new SubscriptionNotification(Notice.Type.SUBSCRIPTION_NOTICE, sub);
		Response response = subService.notifySubscription(subNotice);
		assertThat (response.isSuccess(), is(true));
	}
	
}
