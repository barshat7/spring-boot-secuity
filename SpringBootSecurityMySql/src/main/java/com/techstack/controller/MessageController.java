package com.techstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unsecured")
public class MessageController {

	@GetMapping("/msg")
	public String getMessage(){
		return "This is unsecured message";
	}
}
