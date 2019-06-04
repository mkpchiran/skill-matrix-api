package com.wiley.internal.apps.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.service.SkillService;

@RestController
public class SkillResource {
	
	private SkillService skillService;

	@Autowired
	public SkillResource(final SkillService skillService) {
		this.skillService = skillService;
	}
	
	@PostMapping("/skills")
	public Skill handleSkillCreateAndUpdate(@RequestBody Skill skill) {
		return this.skillService.createSkill(skill);
	}
	
	@GetMapping("/skills/{skillId}")
	public void handleSkillGet(@PathVariable Long skillId) {
		
	}
	
	@GetMapping("/skills")
	public List<Skill> handleSkillGetAll() {
		return this.skillService.retrieveAllSkills();
	}
	
	@DeleteMapping("/skills/{skillId}")
	public void handleSkillDelete(@PathVariable Long skillId) {
		this.skillService.deleteSkill(skillId);
	}

}
