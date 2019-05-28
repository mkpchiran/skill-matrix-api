package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.dto.UserRequest;
import com.wiley.internal.apps.dto.UserResponse;

public interface UserService {

	List<UserResponse> insertNewUser(UserRequest user);
	
	List<UserResponse> getAllUsers();
	
	UserResponse getUserByName(String userName);
}
