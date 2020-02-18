package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Paiment;

public interface PaimentRepository extends JpaRepository<Paiment,Long> {
	List<Paiment> findAll();

}
