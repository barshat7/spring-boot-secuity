package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Authorization Part
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN") // admin should be accessed by only users with admin role
			.anyRequest().hasAnyRole("USER","ADMIN") // Rest can be accessed by anyone
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.permitAll()
				.and().httpBasic();
		
		
	}
	
	
	// Authentication Part
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
			.withUser("user123")
			.password("$2a$10$pXaTXJSe1xVvXv154WKWjuwvTYhlLGT6vMlzObGFwl54YKRgLXYxS")
			.roles("USER","ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
