package com.techstack.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstack.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByFirstName(String firstName);

}