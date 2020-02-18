package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByRole(String role);
	List<Role> findAll();

}