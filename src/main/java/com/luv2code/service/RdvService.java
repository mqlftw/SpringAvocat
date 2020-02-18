package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.RDV;

public interface RdvService {

	void save(RDV rdv);
	void delete(Long id);
	List<RDV> getRDV();
	RDV getRDVbyId(Long id);
	List<RDV> findBysujetRDV(String sujetRDV);
}
