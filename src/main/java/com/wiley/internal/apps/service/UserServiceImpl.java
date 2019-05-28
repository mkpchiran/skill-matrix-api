package com.wiley.internal.apps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.dto.UserRequest;
import com.wiley.internal.apps.dto.UserResponse;
import com.wiley.internal.apps.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserResponse> insertNewUser(UserRequest userRequest) {
		
		User user = new User();
		user.setUserName(userRequest.getUserName());
		
		this.userRepository.save(user);
		
		List<UserResponse> userResponseList = new ArrayList<>();
		
		this.userRepository.findAll().forEach(userItem -> {
			UserResponse userResponse = new UserResponse();
			userResponse.setId(userItem.getId());
			userResponse.setName(userItem.getUserName());
			
			userResponseList.add(userResponse);
		});
		
		return userResponseList;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		
		List<UserResponse> userResponseList = new ArrayList<>();
		
		this.userRepository.findAll().forEach(userItem -> {
			UserResponse userResponse = new UserResponse();
			userResponse.setId(userItem.getId());
			userResponse.setName(userItem.getUserName());
			
			userResponseList.add(userResponse);
		});
		
		return userResponseList;
	}

	@Override
	public UserResponse getUserByName(String userName) {

		User user = this.userRepository.findByUserName(userName);

		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getUserName());

		return userResponse;
	}

}
