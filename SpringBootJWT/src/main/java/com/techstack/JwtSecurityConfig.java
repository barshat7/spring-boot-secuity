package com.techstack;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techstack.security.JwtAuthenticationEntryPoint;
import com.techstack.security.JwtAuthenticationProvider;
import com.techstack.security.JwtAuthenticationTokenFilter;
import com.techstack.security.JwtSuccessHandler;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	// Use JWT Filters
	
	@Bean
	public AuthenticationManager authenticationManager(){
	
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}
	
	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter(){
		
		JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
		return filter;
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/secured/**").authenticated()
			.anyRequest().permitAll()
			.and()
			.exceptionHandling().authenticationEntryPoint(entryPoint) // Redirection to error page in case of failure
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // We don't want spring to manage security through sessions
		
		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class); // Enable our jwt filter before Spring's security filter
		
		http.headers().cacheControl();
	}
	
}
