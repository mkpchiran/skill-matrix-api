package com.wiley.internal.apps.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.SkillLevel;
import com.wiley.internal.apps.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> { 
	
	Optional<UserSkill> findBySkillAndSkillLevel(Skill skill, SkillLevel skillLevel);
}
