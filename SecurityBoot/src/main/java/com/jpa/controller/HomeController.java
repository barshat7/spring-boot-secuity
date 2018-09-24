package com.jpa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String home(){
		return "home";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "login";
	}
}
