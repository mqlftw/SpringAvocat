package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

	 List<Client> findAll();
	List<Client> findBynomClientContaining(String nomClient);

}
