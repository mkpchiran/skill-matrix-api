package com.wiley.internal.apps.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.UserAuthGroup;
import com.wiley.internal.apps.dto.UserAuthGroupsResponse;
import com.wiley.internal.apps.repo.UserAuthGroupRepository;

@Service
public class UserAuthServiceImpl implements UserAuthService{

	@Autowired
	private UserAuthGroupRepository userAuthGroupRepository;
	
	@Override
	public UserAuthGroupsResponse getByUsername(String username) {
		
		return new UserAuthGroupsResponse(username,
											userAuthGroupRepository.findByUsername(username)
											.stream().map(UserAuthGroup::getAuthGroup)
											.collect(Collectors.toList()));
	}

}
