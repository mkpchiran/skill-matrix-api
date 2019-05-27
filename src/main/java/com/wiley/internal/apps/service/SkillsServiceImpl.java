package com.wiley.internal.apps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.dto.SkillsRequest;
import com.wiley.internal.apps.dto.SkillsResponse;
import com.wiley.internal.apps.exception.SkillNotFoundException;
import com.wiley.internal.apps.repo.SkillsRepository;

@Service
public class SkillsServiceImpl implements SkillsService {
	
	private SkillsRepository skillRepository;
	
	@Autowired
	public SkillsServiceImpl(SkillsRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public String insertNewSkill(SkillsRequest skillsRequest) {
		skillRepository.save(new Skill("Java"));
		skillRepository.save(new Skill("Node"));
		skillRepository.save(new Skill("Python"));
		
		skillRepository.findAll().forEach(x -> System.out.println(x));
		
		return "new skills added ...";
	}

	@Override
	public List<SkillsResponse> getSkillsByName(String skillName) {
		
		List<SkillsResponse> skillsResponses =new ArrayList<>();
		
		skillRepository.findByName(skillName).forEach(skill -> {
			SkillsResponse skillResponse = new SkillsResponse();
			skillResponse.setId(skill.getId());
			skillResponse.setName(skill.getName());
			skillsResponses.add(skillResponse);
		});
		
		if (skillsResponses.size() == 0) {
			throw new SkillNotFoundException("Skill is not found for : " + skillName);
		}
		
		return skillsResponses;
	}

	@Override
	public List<SkillsResponse> getAllSkills() {
		/*
		 * skillRepository.save(new Skill("Java")); skillRepository.save(new
		 * Skill("Node")); skillRepository.save(new Skill("Python"));
		 */
		
		List<SkillsResponse> skillsResponses =new ArrayList<>();
		
		skillRepository.findAll().forEach(x -> System.out.println(x));
		
		skillRepository.findAll().forEach(skill -> {
			SkillsResponse skillResponse = new SkillsResponse();
			skillResponse.setId(skill.getId());
			skillResponse.setName(skill.getName());
			skillsResponses.add(skillResponse);
		});
		
		return skillsResponses;
	}

}
