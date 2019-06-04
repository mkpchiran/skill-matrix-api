package com.wiley.internal.apps.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SKILL")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private Long id;

	@Column(name = "Name")
	@Size(max = 10, message = "skill name can not have more than 10 characters")
	private String name;

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

}
