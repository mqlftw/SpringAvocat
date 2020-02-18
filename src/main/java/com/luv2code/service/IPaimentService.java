package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.Paiment;

public interface IPaimentService {

	void save(Paiment paiment);
	void delete(Long id);
	
	List<Paiment> getAllPaiments();
	Paiment getPaimentById(Long id);

}
