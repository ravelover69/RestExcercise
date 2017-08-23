package com.rest.excercise.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rest.excercise.domain.Subscription;
import com.rest.excercise.domain.UserAccount;
import com.rest.excercise.domain.UserAccountNotification;
import com.rest.excercise.domain.entities.ErrorResponse;
import com.rest.excercise.domain.entities.ErrorResponse.ErrorCode;
import com.rest.excercise.domain.entities.Response;
import com.rest.excercise.domain.entities.SuccessResponse;

@Service
public class UserAccountService {
	
	private  Map<String, UserAccount> userAccountMap;
	
	public UserAccountService() {
		this.userAccountMap = new HashMap<String, UserAccount>();
	}

	public  Map<String, UserAccount> getUserAccountMap() {
		return userAccountMap;
	}
	
	/*
	 * Assign user
	 */
	public Response assignUser (UserAccountNotification uAccountNotification)
	{
		String uid = uAccountNotification.getUserAccount().getPayload().getUser().getUuid();
		userAccountMap.put(uid,  uAccountNotification.getUserAccount());
		
		return new SuccessResponse("User Assigned subscription");
	}
	
	/*
	 * UnAssign user
	 */
	public Response unAssignUser (UserAccountNotification uAccountNotification)
	{
		String uid = uAccountNotification.getUserAccount().getPayload().getUser().getUuid();
		UserAccount userAccount = userAccountMap.remove(uid);
		Response response;
		if (userAccount == null) {
			response = new ErrorResponse(ErrorCode.USER_NOT_FOUND, "User Not found");
		}
		else {
			response = new SuccessResponse(uid,  "User unassigned");
		}
		return response;
	}
	
	
	/*
	 * Update User Account
	 */
	public Response updateUser (UserAccountNotification uAccountNotification)
	{
		String uid = uAccountNotification.getUserAccount().getPayload().getUser().getUuid();
		UserAccount userAccount = userAccountMap.remove(uid);
		Response response;
		if (userAccount == null) {
			response = new ErrorResponse(ErrorCode.USER_NOT_FOUND, "User Not found");
		}
		else {
			userAccountMap.put(uid, uAccountNotification.getUserAccount());
			response = new SuccessResponse(uid,  "User updated");
		}
		return response;
	}

	

}
