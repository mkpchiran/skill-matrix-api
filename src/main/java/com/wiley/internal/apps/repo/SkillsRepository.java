package com.wiley.internal.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.Skill;

public interface SkillsRepository extends JpaRepository<Skill, Long> {

	 List<Skill> findByName(String name);
}
