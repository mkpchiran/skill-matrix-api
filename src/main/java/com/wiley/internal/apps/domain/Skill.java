package com.wiley.internal.apps.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private Long id;
	
	private String name;
	
	
	@OneToMany(mappedBy = "skill")
	private Set<UserSkill> userSkills = new HashSet<>();

	public Skill() {
		
	}
	
	public Skill(String name) {
		this.name = name;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(Set<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}

	public String toString() {
		return "Skill Id : " + this.id + " Skill Name : " + this.name;
	}

}
