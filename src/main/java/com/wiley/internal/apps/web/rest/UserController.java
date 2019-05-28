package com.wiley.internal.apps.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.dto.SkillSearchRequest;
import com.wiley.internal.apps.dto.UserRequest;
import com.wiley.internal.apps.dto.UserResponse;
import com.wiley.internal.apps.service.SkillService;
import com.wiley.internal.apps.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService userService;
	
	private SkillService skillService;
	
	@Autowired
	public UserController(UserService userService, SkillService skillService) {
		this.userService = userService;
		this.skillService = skillService;
	}
	
	@GetMapping
	public List<UserResponse> handleUserGetAll() {
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/{userName}")
	public UserResponse handleUserGetByName(@PathVariable String userName) {
		return this.userService.getUserByName(userName);
	}
	
	@GetMapping("/skills")
	public List<UserResponse> handleUserGetForSkills(@RequestParam String filter) {
		
		List<SkillSearchRequest> skillSearchRequestList = new ArrayList<>();
		
		String [] filterArray = filter.split("&");
		for (String string : filterArray) {
			SkillSearchRequest searchRequest = new SkillSearchRequest();
			String [] critrias = string.split(";");
			searchRequest.setSkillName(critrias[0].split("::")[1]);
			
			if (critrias.length > 1) {
				searchRequest.setSkillLevel(critrias[1].split("::")[1]);
			}
			
			skillSearchRequestList.add(searchRequest);
		}
		
		return this.skillService.getUsersForSkills(skillSearchRequestList);
	}
	
	@PostMapping
	public List<UserResponse> handleUserAdd(@RequestBody UserRequest userRequest) {
		return this.userService.insertNewUser(userRequest);
	}
	
}
