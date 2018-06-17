package com.techstack.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse httpServletResponse, AuthenticationException exc)
			throws IOException, ServletException {
		
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"UNAUTHORIZED TO USE");
		
	}

}
