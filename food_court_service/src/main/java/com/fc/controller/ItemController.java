package com.fc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.model.Item;
import com.fc.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping
	public String saveItem(@RequestBody Item item) {
		itemRepository.save(item);
		return "item saved";
	}
	
	@GetMapping("/all")
	public List<Item> getAll(){
		return itemRepository.findAll();
	}
}
