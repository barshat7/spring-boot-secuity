package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.entity.User;
import com.jpa.service.UserServiceImpl;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping
	public String register(){
		
		return "registration-page";
	}
	@PostMapping
	public String register(User user){
		
		userService.saveUser(user);
		return "login";
	}
}
