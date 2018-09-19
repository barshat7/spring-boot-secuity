package com.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainTest {

	public static void main(String args[]) {
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = encoder.encode("test123");
		System.out.println(pass);
	}
}
