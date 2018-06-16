package com.techstack.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.model.Product;

@RestController
public class InventoryController {

	@GetMapping("/products")
	public List<Product> getProducts(){
		
		Product p1 = new Product("Two Wheeler","R15",110);
		Product p2 = new Product("Four Wheeler","CITY",430);
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		return products;
		
	}
	
	@GetMapping("/categories")
	public List<String> getAllCategories(){
		
		List cat = new ArrayList<>();
		cat.add("Two Wheeler");
		cat.add("Four Wheeler");
		return cat;
	}
}
