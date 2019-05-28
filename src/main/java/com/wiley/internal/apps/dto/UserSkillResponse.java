package com.wiley.internal.apps.dto;

import java.util.Set;

public class UserSkillResponse {

	private UserResponse user;
	
	private Set<SkillResponse> skill;

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public Set<SkillResponse> getSkill() {
		return skill;
	}

	public void setSkill(Set<SkillResponse> skill) {
		this.skill = skill;
	}

}
