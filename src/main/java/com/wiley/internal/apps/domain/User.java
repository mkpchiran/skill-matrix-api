package com.wiley.internal.apps.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USER_NAME")
	@Size(min = 2, max = 20, message = "user name atleast should have 2 characters and not more than 20 characters")
	private String userName;

	@Column(name = "DESIGNATION")
	@Size(min = 2, max = 50, message = "designation atleast should have 2 characters and not more than 50 characters")
	private String designation;

	public User() {

	}

	public User(final String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
