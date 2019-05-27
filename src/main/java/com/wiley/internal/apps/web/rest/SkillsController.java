package com.wiley.internal.apps.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.dto.SkillsRequest;
import com.wiley.internal.apps.dto.SkillsResponse;
import com.wiley.internal.apps.service.SkillsService;

@RestController
@RequestMapping("api/v1/skills")
public class SkillsController {
	
	private SkillsService skillsService;
	
	@Autowired
	public SkillsController(SkillsService skillsService) {
		this.skillsService = skillsService;
	}
	
	@GetMapping
	public List<SkillsResponse> handleSkillsGetAll() {
		return this.skillsService.getAllSkills();
	}
	
	@GetMapping("/{skillName}")
	public List<SkillsResponse> handleSkillsGetByName(@PathVariable String skillName) {
		return this.skillsService.getSkillsByName(skillName);
	}
	
	@PostMapping
	public String handleSkillsAdd(@RequestBody SkillsRequest skillsRequest) {
		return this.skillsService.insertNewSkill(skillsRequest);
	}
	
}
