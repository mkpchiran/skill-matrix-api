package com.wiley.internal.apps.domain;

import java.sql.Date;
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
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long Id;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@OneToMany(mappedBy = "user")
	private Set<UserSkill> userSkills = new HashSet<>();
	
    @Column(name="PASSWORD")
    private String password;
	
	@Column(name = "WILEY_DESIGNATION")
    private String Wiley_Designation;
    
	@Column(name = "CURRENT_DESIGNATION", nullable = true)
    private String Current_Designation;

	@Column(name = "WILEY_START_DATE")
    private Date startDate;

	@Column(name = "TOTAL_EXPERIENCE")
    private Long totalExperience;
    
	@Column(name = "EXPERIENCE_IN_CURRENT_DESIGNATION")
    private Long experienceInCurrentDesignation;
    
	public User() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(Set<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}
	
	public String getWiley_Designation() {
		return Wiley_Designation;
	}

	public void setWiley_Designation(String wiley_Designation) {
		Wiley_Designation = wiley_Designation;
	}

	public String getCurrent_Designation() {
		return Current_Designation;
	}

	public void setCurrent_Designation(String current_Designation) {
		Current_Designation = current_Designation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Long totalExperience) {
		this.totalExperience = totalExperience;
	}

	public Long getExperienceInCurrentDesignation() {
		return experienceInCurrentDesignation;
	}

	public void setExperienceInCurrentDesignation(Long experienceInCurrentDesignation) {
		this.experienceInCurrentDesignation = experienceInCurrentDesignation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
