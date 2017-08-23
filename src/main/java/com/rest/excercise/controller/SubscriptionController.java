package com.rest.excercise.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.excercise.domain.Subscription;
import com.rest.excercise.domain.SubscriptionNotification;
import com.rest.excercise.domain.entities.ErrorResponse;
import com.rest.excercise.domain.entities.ErrorResponse.ErrorCode;
import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Response;
import com.rest.excercise.service.SubscriptionService;

/*
 * Controller for Subscription management.
 */

@RestController
@RequestMapping("/sub")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	
	/*
	 * Create Subscription
	 */
	
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createSubscriptionUrl(@RequestParam("url") String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_ORDER) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.createSubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;
	}
	
	
	/*
	 * Change Subscription
	 */
	@RequestMapping(value = "/change/", method = RequestMethod.PUT)
	public ResponseEntity<?> changeSubscriptionUrl(@RequestParam("url") String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_CHANGE) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.changeSubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;
	}
	
	
	/*
	 * Cancel Subscription
	 */
	
	@RequestMapping(value = "/cancel/", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelSubscriptionUrl(@RequestParam("url") String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_CANCEL) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.cancelSubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;

	}
	
	/*
	 * Notify of subscription status change
	 */
	
	@RequestMapping(value = "/notify/", method = RequestMethod.POST)
	public ResponseEntity<?> notifySubscriptionUrl(@RequestParam ("url") String url) {
		System.out.println("In notified");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_NOTICE) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.notifySubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;

	}
	
	
	/*
	 * List all current subscription
	 */
	
	@RequestMapping(value = "/subscription/", method = RequestMethod.GET)
	public List <Subscription> listSubscription() {
		System.out.println("In list subscription");
		Map <String, Subscription> subscriptionMap = subscriptionService.getAllSubscription();
		List <Subscription> sList = subscriptionMap.values().stream().collect(Collectors.toList());
		return sList;
	}
	
}
