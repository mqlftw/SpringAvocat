package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.Tribunal;

public interface ITribunalService {

	List<Tribunal> getAllTribunals();
	void save(Tribunal tribunal);
	void delete(Long id);
	Tribunal getTribunalById(Long id);
	List<Tribunal> findBylieuTribunal(String lieuTribunal);
}
