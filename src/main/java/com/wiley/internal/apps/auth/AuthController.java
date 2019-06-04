package com.wiley.internal.apps.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserAuthGroup;
import com.wiley.internal.apps.repo.UserAuthGroupRepository;
import com.wiley.internal.apps.repo.UserRepository;

@Controller
public class AuthController {
	
	@Autowired
	private WileyUserDetailsService wileyUserDetailsService;
	
	@Autowired
	private UserAuthGroupRepository userAuthGroupRepository;
	
	@Autowired
	private UserRepository userRepository;

    @RequestMapping("/authorization-code/callback")
    @ResponseBody
    public String home(@AuthenticationPrincipal OidcUser oidcUser) {
    	
    	User user = userRepository.findByUserName(oidcUser.getEmail());
    	if(user == null) {
    		User newUser = new User();
    		newUser.setUserName(oidcUser.getEmail());
    		newUser = userRepository.save(newUser);
    		
    		UserAuthGroup authGroup = new UserAuthGroup();
    		authGroup.setAuthGroup("USER");
    		authGroup.setUsername(newUser.getUserName());
    		authGroup = userAuthGroupRepository.save(authGroup);
    		
    	}
        return "Welcome, " + oidcUser.getFullName();
    }

    @RequestMapping("/attributes")
    @ResponseBody
    public String attributes(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAttributes().toString();
    }

    @RequestMapping("/authorities")
    @ResponseBody
    public String authorities(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAuthorities().toString();
    }
    
}