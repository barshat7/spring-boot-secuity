package com.techstack.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredMessageController {

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/msg")
	public String getMessage(){
		
		return "This is a SECURED Message!!";
	}
}
