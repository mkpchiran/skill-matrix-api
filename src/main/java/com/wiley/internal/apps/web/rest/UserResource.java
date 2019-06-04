package com.wiley.internal.apps.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.service.UserService;
import com.wiley.internal.apps.service.UserSkillService;

@RestController
public class UserResource {

	private UserService userService;

	private UserSkillService userSkillService;

	@Autowired
	public UserResource(final UserService userService, final UserSkillService userSkillService) {
		this.userService = userService;
		this.userSkillService = userSkillService;
	}

	@GetMapping("/v1/users/{userName}")
	public User handleUserGet(@PathVariable String userName) {
		return this.userService.findUser(userName);
	}

	@DeleteMapping("/v1/users/{userName}")
	public void handleUserDelete(@PathVariable String userName) {
		this.userService.deleteUser(userName);
	}

	@PostMapping("/v1/users/{userName}/skills")
	public ResponseEntity<UserSkill> handleUserSkillCreate(@RequestBody UserSkill userSkill) {
		return new ResponseEntity<>(this.userSkillService.createSkillForUser(userSkill), HttpStatus.CREATED);
	}

}
