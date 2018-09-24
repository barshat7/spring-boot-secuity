package com.jpa.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.entity.User;

@Controller
@RequestMapping("/api/search")
public class SearchController {

	@GetMapping
	public String search(@RequestParam("query") String query, @AuthenticationPrincipal UserDetails user){
		
		System.out.println("Search For:" +query +"   User is: " +user==null?"Null User":user.getUsername());
		return "search";
	}
}
