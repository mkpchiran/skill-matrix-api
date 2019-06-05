package com.wiley.internal.apps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.SkillLevel;
import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.exception.SkillLevelNotFoundException;
import com.wiley.internal.apps.exception.SkillNotFoundException;
import com.wiley.internal.apps.exception.UserNotFoundException;
import com.wiley.internal.apps.repo.SkillLevelRepository;
import com.wiley.internal.apps.repo.SkillRepository;
import com.wiley.internal.apps.repo.UserRepository;
import com.wiley.internal.apps.repo.UserSkillRepository;

@Service
public class UserSkillServiceImpl implements UserSkillService {
	
	private UserRepository userRepository;
	private SkillRepository skillRepository;
	private SkillLevelRepository skillLevelRepository;
	private UserSkillRepository userSkillRepository;

	public UserSkillServiceImpl(final UserRepository userRepository, final SkillRepository skillRepository, final SkillLevelRepository skillLevelRepository,
			final UserSkillRepository userSkillRepository) {
		this.userRepository = userRepository;
		this.skillRepository = skillRepository;
		this.skillLevelRepository = skillLevelRepository;
		this.userSkillRepository = userSkillRepository;
	}

	@Override
	public UserSkill createSkillForUser(UserSkill userSkill) {
		
		String userName = userSkill.getUser().getUserName();
		Optional<User> user = this.userRepository.findById(userName);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("User does not exsits :: " + userName);
		}
		
		Long skillId = userSkill.getSkill().getId();
		Optional<Skill> skill = this.skillRepository.findById(skillId);
		
		if (!skill.isPresent()) {
			throw new SkillNotFoundException("Skill does not exsits :: " + skillId);
		}
		
		Long skillLevelId = userSkill.getSkillLevel().getId();
		Optional<SkillLevel> skillLevel = this.skillLevelRepository.findById(skillLevelId);
		
		if (!skillLevel.isPresent()) {
			throw new SkillLevelNotFoundException("Skill Level does not exsits :: " + skillLevelId);
		}
		
		userSkill.setUser(user.get());
		userSkill.setSkill(skill.get());
		userSkill.setSkillLevel(skillLevel.get());
		
		return this.userSkillRepository.save(userSkill);
	}

	@Override
	public List<UserSkill> getSkillForUser(String username) {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepository.findById(username);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("User does not exsits :: " + username);
		}
		return this.userSkillRepository.findByUser(user.get());
	}

}
