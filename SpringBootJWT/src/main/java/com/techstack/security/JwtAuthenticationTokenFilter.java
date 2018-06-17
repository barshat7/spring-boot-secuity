package com.techstack.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.techstack.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	public  JwtAuthenticationTokenFilter() {
		super("/secured/**");
		
	}
	/*AuthenticationManager authenticationManager;
	JwtSuccessHandler jwtSuccessHandler;*/
	
	/*public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		
		this.authenticationManager=authenticationManager;
	}
	public void setAuthenticationSuccessHandler(JwtSuccessHandler jwtSuccessHandler) {
		
		this.jwtSuccessHandler=jwtSuccessHandler;
	}*/
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String header = request.getHeader("Authorisation");
		if(header==null || !header.startsWith("Token")){
			
			throw new RuntimeException("JWT TOKEN IS MISSING");
		}
		
		String authenticationToken = header.substring(6);
		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
		
		return getAuthenticationManager().authenticate(token);
	}
	
	
	// After successful authentication, proceed with the filter chain
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
	
	

}
