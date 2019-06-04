package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.domain.Skill;

public interface SkillService {
	
	Skill createSkill(Skill skill);
	
	List<Skill> retrieveAllSkills();
	
	void deleteSkill(Long skillId);
}
