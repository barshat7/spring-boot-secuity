package com.techstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class AccountController {

	@GetMapping("/msg")
	public String msg(){
		
		return "Secured Message: Hello JWT!!";
	}
}
