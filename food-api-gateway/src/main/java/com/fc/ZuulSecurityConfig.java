package com.fc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fc.security.JwtConfig;
import com.fc.security.JwtTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ZuulSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig()), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST,jwtConfig().getUri()).permitAll()
			.anyRequest().authenticated();
			
	}
	
	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}
}
