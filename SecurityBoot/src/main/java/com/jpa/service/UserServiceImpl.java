package com.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpa.entity.Role;
import com.jpa.entity.User;
import com.jpa.repository.RoleRepository;
import com.jpa.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User findUserByUsername(String username){
		
		return userRepository.findByUsername(username);
	}
	
	public void saveUser(User user){
		
		List<Role> roles = roleRepository.findAll();
		
		List<Role> _roles = roles.stream()
			.filter(r->r.getName().contains("USER"))
			.collect(Collectors.toList());
		
		user.setRoles(_roles);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		System.out.println("Saving User: " +user.getUsername());
		userRepository.save(user);
		
	}
}
