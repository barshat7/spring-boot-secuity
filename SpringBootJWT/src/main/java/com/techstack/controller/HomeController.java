package com.techstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.model.JwtUser;
import com.techstack.security.JwtGenerator;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private JwtGenerator jwtGenerator;
	
	@GetMapping("/msg")
	public String home(){
		
		return "Unsecured: HOME";
	}
	
	/*@PostMapping("/token")
	public String generateToken(@RequestBody final JwtUser jwtUser){
		
		
		return jwtGenerator.generate(jwtUser);
		
	}*/
}
