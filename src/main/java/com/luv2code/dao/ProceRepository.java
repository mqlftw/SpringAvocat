package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Proce;

public interface ProceRepository extends JpaRepository<Proce,Long>
{

	List <Proce> findBysujetProceContaining(String sujetProce);
	Proce findBysujetProce(String sujetProce);
}
