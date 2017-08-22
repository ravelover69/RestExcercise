package com.rest.excercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.rest.excercise.domain.UserAccountNotification;
import com.rest.excercise.domain.entities.ErrorResponse;
import com.rest.excercise.domain.entities.Notice;
import com.rest.excercise.domain.entities.Response;
import com.rest.excercise.domain.entities.ErrorResponse.ErrorCode;
import com.rest.excercise.service.UserAccountService;

@RestController
@RequestMapping("/user")
public class UserAccountController {
	
	@Autowired
	UserAccountService uAccountservice;
	
	
	@RequestMapping(value = "/assign/", method = RequestMethod.POST)
	public ResponseEntity<?> assignUserUrl (@RequestParam ("url") String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		UserAccountNotification uAccountNotification = restTemplate.getForObject(url, UserAccountNotification.class);
		if (uAccountNotification.getSubscriptType() != Notice.Type.USER_ASSIGNMENT) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = uAccountservice.assignUser(uAccountNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;
	}
	 
	
	/*
	 * Unassign user
	 */
	@RequestMapping(value = "/unassign/", method = RequestMethod.POST)
	public ResponseEntity<?> unAssignUserUrl (@RequestParam ("url") String url) {
		System.out.println("In User UnAssignment");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		UserAccountNotification uAccountNotification = restTemplate.getForObject(url, UserAccountNotification.class);
		if (uAccountNotification.getSubscriptType() != Notice.Type.USER_UNASSIGNMENT) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = uAccountservice.unAssignUser(uAccountNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;
	}
	
	
	/*
	 * Update User Account
	 */
	@RequestMapping(value = "/update/", method = RequestMethod.PUT)
	public ResponseEntity<?> changeUserUrl (@RequestParam ("url") String url) {
		System.out.println("In User Change");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Response> reponseEntity;
		UserAccountNotification uAccountNotification = restTemplate.getForObject(url, UserAccountNotification.class);
		if (uAccountNotification.getSubscriptType() != Notice.Type.USER_UPDATED) {
			reponseEntity = new ResponseEntity<Response>(new ErrorResponse (ErrorCode.CONFIGURATION_ERROR, "Invalid Notice"), HttpStatus.BAD_REQUEST);
		}
		else {
			 Response response = uAccountservice.updateUser(uAccountNotification);
			 reponseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return reponseEntity;
	}
	
}
