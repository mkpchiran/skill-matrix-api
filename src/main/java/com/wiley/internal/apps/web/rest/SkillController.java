package com.wiley.internal.apps.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.dto.UserSkillRequest;
import com.wiley.internal.apps.dto.SkillRequest;
import com.wiley.internal.apps.dto.SkillResponse;
import com.wiley.internal.apps.dto.UserSkillResponse;
import com.wiley.internal.apps.service.SkillService;

@RestController
@RequestMapping("api/v1/skills")
public class SkillController {
	
	private SkillService skillsService;
	
	@Autowired
	public SkillController(SkillService skillsService) {
		this.skillsService = skillsService;
	}
	
	@GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
	public List<SkillResponse> handleSkillGetAll() {
		return this.skillsService.getAllSkills();
	}
	
	@GetMapping("/{skillName}")
	public SkillResponse handleSkillGetByName(@PathVariable String skillName) {
		return this.skillsService.getSkillByName(skillName);
	}
	
	@PostMapping
	public List<SkillResponse> handleSkillAdd(@RequestBody SkillRequest skillsRequest) {
		return this.skillsService.insertNewSkill(skillsRequest);
	}
	
	@PostMapping("/{userName}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserSkillResponse handleSkillAddForUser(@PathVariable String userName, @RequestBody UserSkillRequest skillsRequest) {
		return this.skillsService.addSkillToUser(userName, skillsRequest);
	}

}
