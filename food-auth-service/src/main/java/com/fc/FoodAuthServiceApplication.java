package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAuthServiceApplication.class, args);
	}
}
