package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.Proce;
import com.luv2code.entities.Seance;

public interface ISeanceService {

	List<Seance> getAllSeances();
	void save(Seance seance);
	void delete(Long id);
	Seance getSeanceById(Long id);
	
	Seance getSeanceByProce(Proce proce);
}
