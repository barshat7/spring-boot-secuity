package com.fc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fc.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	public Item getByCode(String code);
}
