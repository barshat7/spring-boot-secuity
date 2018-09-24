package com.jpa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

	public static void main(String[] args) {
		
		PasswordEncoder en = new BCryptPasswordEncoder();
		System.out.println(en.encode("test"));

	}

}
