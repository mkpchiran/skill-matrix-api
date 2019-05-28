package com.wiley.internal.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

	 Skill findByName(String name);
}
