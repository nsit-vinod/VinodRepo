package com.ipark.rest.webservices.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.UserGroup;
import com.ipark.rest.webservices.repository.UserGroupRepository;
import com.ipark.rest.webservices.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserGroupRepository userGroupRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("User not found");
		}
		List<UserGroup> groups = userGroupRepository.findByUser(user);
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(UserGroup group: groups) {
			GrantedAuthority authoritie = new SimpleGrantedAuthority("ROLE_"+group);
			authorities.add(authoritie);
		}
		return new CustomUserDetails(user,authorities);
	}

}
