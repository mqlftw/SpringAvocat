package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String userName);
	List<User> findByUsernameContaining(String userName);

}

