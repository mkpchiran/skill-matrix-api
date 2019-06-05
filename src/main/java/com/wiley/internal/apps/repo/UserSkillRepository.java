package com.wiley.internal.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> { 
	
	List<UserSkill> findByUser(User user);
}