package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.dto.SkillsRequest;
import com.wiley.internal.apps.dto.SkillsResponse;

public interface SkillsService {

	String insertNewSkill(SkillsRequest skillsRequest);
	
	List<SkillsResponse> getAllSkills();
	
	List<SkillsResponse> getSkillsByName(String skillName);
	
}
