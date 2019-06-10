package com.wiley.internal.apps.auth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserAuthGroup;
import com.wiley.internal.apps.repo.UserAuthGroupRepository;
import com.wiley.internal.apps.repo.UserRepository;

@Component
public class VerifyAccessInterceptor implements HandlerInterceptor {

	@Autowired
	private UserAuthGroupRepository userAuthGroupRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(!auth.isAuthenticated() || auth.getName().equalsIgnoreCase("anonymousUser")) {
			return true;
		}
		
		Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
		User user = userRepository.findById(auth.getName()).get();

		if (user == null) {
			user = new User();
			user.setUserName(auth.getName());
			user = userRepository.save(user);
			System.out.println(user.getDesignation());
			UserAuthGroup authGroup = new UserAuthGroup();
			authGroup.setAuthGroup("USER");
			authGroup.setUsername(user.getUserName());
			authGroup = userAuthGroupRepository.save(authGroup);
		}

		List<UserAuthGroup> authGroups = userAuthGroupRepository.findByUsername(auth.getName());
		// add whatever authorities you want here
		authGroups.forEach(group -> {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + group.getAuthGroup()));
		});

		Authentication newAuth = null;

		if (auth.getClass() == JwtAuthenticationToken.class) {
			Jwt jwt = ((JwtAuthenticationToken) auth).getToken();
			newAuth = new JwtAuthenticationToken(jwt, grantedAuthorities);
		} else {
			newAuth = auth;
		}
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return true;
	}
}
