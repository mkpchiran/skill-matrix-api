package com.wiley.internal.apps.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.service.UserAuthService;
import com.wiley.internal.apps.service.UserService;
import com.wiley.internal.apps.service.UserSkillService;

@RestController
public class UserResource {

	private UserService userService;
	
	private UserSkillService userSkillService;
	
	private UserAuthService userAuthService;
	
	public UserResource(
			final UserService userService, 
			final UserSkillService userSkillService, 
			final UserAuthService userAuthService) {
		
		this.userService = userService;
		this.userSkillService = userSkillService;
		this.userAuthService = userAuthService;
	}

	@GetMapping("/users/{userName}")
	public User handleUserGet(@PathVariable String userName) {
		return userService.findUser(userName);
	}
	
	@GetMapping("/users/{userName}/roles")
	public List<String> handleUserGetUserRoles(@PathVariable String userName) {
		return userAuthService.getByUsername(userName);
	}
	
	@DeleteMapping("/users/{userName}")
	public void handleUserDelete(@PathVariable String userName) {
		this.userService.deleteUser(userName);
	}
	
	@PostMapping("/users/{userName}/skills")
	public UserSkill handleUserSkillCreate(@RequestBody UserSkill userSkill) {
		return this.userSkillService.createSkillForUser(userSkill);
	}
	
}
