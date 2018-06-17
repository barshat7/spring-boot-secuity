package com.techstack.security;

import org.springframework.stereotype.Component;

import com.techstack.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 
 * @author Barshat
 *
 *This is the class that will validate the request from the client
 */
@Component
public class JwtValidator {

	private String secret = "enigma";
	
	public JwtUser validate(String token) {
		
		JwtUser jwtUser = null;
		try{
		Claims claimsBody = Jwts.parser()
							.setSigningKey(secret)
							.parseClaimsJws(token)
							.getBody();
		
		jwtUser = new JwtUser();
		jwtUser.setUserName(claimsBody.getSubject());
		jwtUser.setId(Long.parseLong((String)claimsBody.get("userId")));
		jwtUser.setRole((String) claimsBody.get("role"));
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		return jwtUser;
		
	}

}
