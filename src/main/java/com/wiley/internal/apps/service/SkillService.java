package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.dto.UserSkillRequest;
import com.wiley.internal.apps.dto.SkillRequest;
import com.wiley.internal.apps.dto.SkillResponse;
import com.wiley.internal.apps.dto.SkillSearchRequest;
import com.wiley.internal.apps.dto.UserResponse;
import com.wiley.internal.apps.dto.UserSkillResponse;

public interface SkillService {

	List<SkillResponse> insertNewSkill(SkillRequest skillsRequest);
	
	List<SkillResponse> getAllSkills();
	
	SkillResponse getSkillByName(String skillName);
	
	UserSkillResponse addSkillToUser(String userName, UserSkillRequest skillsRequest);
	
	List<UserResponse> getUsersForSkills(List<SkillSearchRequest> searchRequest);
	
}
