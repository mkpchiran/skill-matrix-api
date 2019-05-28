package com.wiley.internal.apps.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.dto.UserRequest;
import com.wiley.internal.apps.dto.UserResponse;
import com.wiley.internal.apps.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserResponse> handleUserGetAll() {
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/{userName}")
	public UserResponse handleUserGetByName(@PathVariable String userName) {
		return this.userService.getUserByName(userName);
	}
	
	@PostMapping
	public List<UserResponse> handleUserAdd(@RequestBody UserRequest userRequest) {
		return this.userService.insertNewUser(userRequest);
	}
	
}
