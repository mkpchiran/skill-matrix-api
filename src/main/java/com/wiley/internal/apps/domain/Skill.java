package com.wiley.internal.apps.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SKILL")
public class Skill {

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private Long id;
	
	@Column(name = "SKILL_NAME")
	private String name;
	
	@Column(name = "SKILL_VERSION")
	private Long version;
	
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
