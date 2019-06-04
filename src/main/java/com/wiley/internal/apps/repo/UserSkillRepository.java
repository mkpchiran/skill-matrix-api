package com.wiley.internal.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> { 
	
}