package com.wiley.internal.apps.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.dto.UserSkillRequest;
import com.wiley.internal.apps.dto.SkillRequest;
import com.wiley.internal.apps.dto.SkillResponse;
import com.wiley.internal.apps.dto.SkillSearchRequest;
import com.wiley.internal.apps.dto.UserResponse;
import com.wiley.internal.apps.dto.UserSkillResponse;
import com.wiley.internal.apps.exception.SkillNotFoundException;
import com.wiley.internal.apps.exception.UserNotFoundException;
import com.wiley.internal.apps.repo.SkillRepository;
import com.wiley.internal.apps.repo.UserRepository;
import com.wiley.internal.apps.repo.UserSkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	
	private SkillRepository skillRepository;
	
	private UserRepository userRepository;
	
	private UserSkillRepository userSkillRepository;
	
	@Autowired
	public SkillServiceImpl(SkillRepository skillRepository, UserRepository userRepository, UserSkillRepository userSkillRepository) {
		this.skillRepository = skillRepository;
		this.userRepository = userRepository;
		this.userSkillRepository = userSkillRepository;
	}

	@Override
	public List<SkillResponse> insertNewSkill(SkillRequest skillsRequest) {

		skillsRequest.getSkills().forEach(skill -> this.skillRepository.save(new Skill(skill)));

		List<SkillResponse> skillsResponseList = new ArrayList<>();

		this.skillRepository.findAll().forEach(skill -> {
			SkillResponse skillResponse = new SkillResponse();
			skillResponse.setId(skill.getId());
			skillResponse.setName(skill.getName());
			skillsResponseList.add(skillResponse);
		});

		return skillsResponseList;
	}

	@Override
	public SkillResponse getSkillByName(String skillName) {
		
		List<SkillResponse> skillsResponses = new ArrayList<>();
		
		Skill skill = this.skillRepository.findByName(skillName);
		
		SkillResponse skillResponse = new SkillResponse();
		skillResponse.setId(skill.getId());
		skillResponse.setName(skill.getName());
		skillsResponses.add(skillResponse);

		return skillResponse;
	}

	@Override
	public List<SkillResponse> getAllSkills() {
		
		List<SkillResponse> skillsResponses = new ArrayList<>();
		
		this.skillRepository.findAll().forEach(skill -> {
			SkillResponse skillResponse = new SkillResponse();
			skillResponse.setId(skill.getId());
			skillResponse.setName(skill.getName());
			skillResponse.setVersion(skill.getVersion());
			skillsResponses.add(skillResponse);
		});
		
		return skillsResponses;
	}

	@Override
	public UserSkillResponse addSkillToUser(String userName, UserSkillRequest skillsRequest) {

		User user = this.userRepository.findByUserName(userName);

		if (user == null) {
			throw new UserNotFoundException("User not found ::: " + userName);
		}

		skillsRequest.getSkills().forEach(skillRequest -> {

			Skill skill = this.skillRepository.findByName(skillRequest.getName());
			
			if (skill == null) {
				throw new SkillNotFoundException("Skill not found ::: " + skillRequest);
			}

			UserSkill oldUserSkill = this.userSkillRepository.findByUserAndSkill(user, skill);

			if (oldUserSkill == null) {
				UserSkill userSkill = new UserSkill();
				userSkill.setSkill(skill);
				userSkill.setUser(user);
				userSkill.setExpRank(skillRequest.getLevel());

				this.userSkillRepository.save(userSkill);
			} else {
				skill.setName(skillRequest.getName());
				oldUserSkill.setSkill(skill);
				oldUserSkill.setExpRank(skillRequest.getLevel());
				this.userSkillRepository.save(oldUserSkill);
			}

		});

		List<UserSkill> userSkillAdded = this.userSkillRepository.findByUser(user);

		UserSkillResponse userSkillResponse = new UserSkillResponse();
		Set<UserResponse> userResponseList = new HashSet<>();
		Set<SkillResponse> skillResponseList = new HashSet<>();

		userSkillAdded.forEach(item -> {
			SkillResponse skillResponse = new SkillResponse();
			skillResponse.setId(item.getSkill().getId());
			skillResponse.setName(item.getSkill().getName());
			skillResponseList.add(skillResponse);

		});

		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getUserName());
		userResponseList.add(userResponse);

		userSkillResponse.setUser(userResponse);
		userSkillResponse.setSkill(skillResponseList);

		return userSkillResponse;
	}

	@Override
	public List<UserResponse> getUsersForSkills(List<SkillSearchRequest> searchRequests) {
		
		List<UserResponse> userResponseList = new ArrayList<>();
		
		searchRequests.forEach(searchItem -> {
			
			List<UserSkill> userSkills = null;
			
			Skill skill = this.skillRepository.findByName(searchItem.getSkillName());
			
			String level = searchItem.getSkillLevel();
			if (level != null && skill != null) {
				userSkills = this.userSkillRepository.findBySkillAndExpRank(skill,Integer.parseInt(level));
			} else if (skill != null) {
				userSkills = this.userSkillRepository.findBySkill(skill);
			} else {
				throw new SkillNotFoundException("Skill Not Found ::: " + searchItem.getSkillName());
			}
			
			userSkills.forEach(userSkill -> {
				UserResponse userResponse = new UserResponse();
				userResponse.setId(userSkill.getId());
				userResponse.setName(userSkill.getUser().getUserName());
				
				userResponseList.add(userResponse);
			});
			
		});
		
		return userResponseList;
	}

}
