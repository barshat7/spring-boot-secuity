package com.techstack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techstack.model.CustomUserDetails;
import com.techstack.model.User;
import com.techstack.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByFirstName(username);
		if(user.isPresent()){
			return new CustomUserDetails(user.get());
		}
		else{
			throw new UsernameNotFoundException("User name not present");
		}
		
	}

}
