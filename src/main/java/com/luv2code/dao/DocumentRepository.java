package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Document;

public interface DocumentRepository extends JpaRepository<Document,Long> {

	List<Document> findAll();
	public List<Document> findBysujetDocContaining(String sujetDoc);
}
