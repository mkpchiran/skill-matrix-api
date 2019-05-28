package com.wiley.internal.apps.dto;

import java.util.List;

public class UserSkillRequest {
	
	private List<UserSkill> skill;

	public List<UserSkill> getSkills() {
		return skill;
	}

	public void setSkills(List<UserSkill> skill) {
		this.skill = skill;
	}
	
}
