package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.RDV;

public interface RDVRepository extends JpaRepository<RDV,Long> {

	public List<RDV> findBysujetRDV(String sujetRDV);

	public List<RDV> findBysujetRDVContaining(String sujetRDV);
}
