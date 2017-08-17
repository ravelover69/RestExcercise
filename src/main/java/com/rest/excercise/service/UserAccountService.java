package com.rest.excercise.service;

import org.springframework.stereotype.Service;

import com.rest.excercise.domain.UserAccount;
import com.rest.excercise.domain.UserAccountNotification;
import com.rest.excercise.domain.entities.SuccessResponse;

@Service
public class UserAccountService {
	
	public SuccessResponse assignUser (UserAccountNotification uAccountNotification)
	{
		return new SuccessResponse("123");
	}
	
	public SuccessResponse unAssignUser (UserAccountNotification uAccountNotification)
	{
		return new SuccessResponse("123");
	}
	
	public SuccessResponse updateUser (UserAccountNotification uAccountNotification)
	{
		return new SuccessResponse("123");
	}

}
