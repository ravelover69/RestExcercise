package com.rest.excercise.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.excercise.domain.SubscriptionNotification;
import com.rest.excercise.domain.entities.ErrorResponse;
import com.rest.excercise.domain.entities.ErrorResponse.ErrorCode;
import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Response;
import com.rest.excercise.domain.entities.SuccessResponse;
import com.rest.excercise.service.SubscriptionService;

@RestController
@RequestMapping("/sub")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createSubscription(@RequestBody SubscriptionNotification newSubscription) {
		System.out.println("In create");
		Response response = subscriptionService.createSubscription(newSubscription);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createSubscriptionUrl(@RequestParam("url") String url) {
		System.out.println("In create");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_ORDER) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice", null, null), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.createSubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;
	}
	
	
	@RequestMapping(value = "/change/", method = RequestMethod.PUT)
	public ResponseEntity<?> changeSubscription(@RequestBody SubscriptionNotification updatedSubscription) {
		System.out.println("In change");
		Response response = subscriptionService.changeSubscription(updatedSubscription);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/change/", method = RequestMethod.PUT)
	public ResponseEntity<?> changeSubscriptionUrl(@RequestParam("url") String url) {
		System.out.println("In change");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_CHANGE) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice", null, null), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.changeSubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;

	}
	
	/*
	 * Delete
	 */
	/*@RequestMapping(value = "/cancel/{acctId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelSubscription(@PathVariable("acctId") String acctId) {
		System.out.println("In delete");
		Response response = subscriptionService.cancelSubscription(acctId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}*/
	
	@RequestMapping(value = "/cancel/", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelSubscriptionUrl(@RequestParam("url") String url) {
		System.out.println("In delete");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_CANCEL) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice", null, null), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.cancelSubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;

	}
	
	
	@RequestMapping(value = "/notify/", method = RequestMethod.POST)
	public ResponseEntity<?> notifySubscription(@RequestBody SubscriptionNotification newSubscription) {
		System.out.println("In notified");
		Response response = subscriptionService.createSubscription(newSubscription);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/notify/", method = RequestMethod.POST)
	public ResponseEntity<?> notifySubscriptionUrl(@RequestParam ("url") String url) {
		System.out.println("In notified");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		SubscriptionNotification subNotification = restTemplate.getForObject(url, SubscriptionNotification.class);
		if (subNotification.getSubscriptType() != Notice.Type.SUBSCRIPTION_NOTICE) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice", null, null), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = subscriptionService.notifySubscription(subNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;

	}
	
	
	

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("name") String name) {
		Response response = new SuccessResponse("name");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
