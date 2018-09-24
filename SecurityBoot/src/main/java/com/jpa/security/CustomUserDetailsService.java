package com.jpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpa.entity.User;
import com.jpa.service.UserServiceImpl;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findUserByUsername(username);
		UserDetails userDetails = new CustomUserDetails(user);
		return userDetails;
	}

}
