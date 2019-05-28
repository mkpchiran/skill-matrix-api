package com.wiley.internal.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
	
	
	public UserSkill findByUserAndSkill(User user, Skill skill);
	
	public List<UserSkill> findByUser(User user);
	
	public List<UserSkill> findBySkill(Skill skill);
	
	public List<UserSkill> findByLevelAndSkill(Integer level, Skill skill);
	
}
