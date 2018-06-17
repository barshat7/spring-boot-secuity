package com.techstack.security;

import org.springframework.stereotype.Component;

import com.techstack.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author Barshat
 * 
 * This class will generate a jwt token for a given user
 *
 */
@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {
		
		Claims claims = Jwts.claims()
							.setSubject(jwtUser.getUserName());
		claims.put("userId", jwtUser.getId().toString());
		claims.put("role",jwtUser.getRole());
							
		
		return Jwts.builder()
			.setClaims(claims)
			.signWith(SignatureAlgorithm.HS512, "enigma")
			.compact();
		
	}

}
