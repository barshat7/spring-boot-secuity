package com.oauth.controller;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/success")
	public String success(OAuth2Authentication authentication) {
		
		Map<String, String> authMap = (Map<String, String>) authentication.getUserAuthentication().getDetails();
		
		System.out.println(authMap);
		return "success";
	}
}
