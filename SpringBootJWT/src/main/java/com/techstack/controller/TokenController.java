package com.techstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.model.JwtUser;
import com.techstack.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping
	public String generateToken(@RequestBody final JwtUser jwtUser){
		
		
		return jwtGenerator.generate(jwtUser);
		
	}
	
}
