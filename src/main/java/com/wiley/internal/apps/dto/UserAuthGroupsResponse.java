package com.wiley.internal.apps.dto;

import java.util.List;

/**
 * @author pchirantha
 *
 */
public class UserAuthGroupsResponse {

	public UserAuthGroupsResponse(String name, List<String> authGroups) {
		super();
		this.name = name;
		this.authGroups = authGroups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAuthGroups() {
		return authGroups;
	}

	public void setAuthGroups(List<String> authGroups) {
		this.authGroups = authGroups;
	}

	private String name;

	private List<String> authGroups;
	
	
}
