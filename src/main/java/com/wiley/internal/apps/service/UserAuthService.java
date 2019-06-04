package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.dto.UserAuthGroupsResponse;

public interface UserAuthService {

	UserAuthGroupsResponse getByUsername(String username);

}
