package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.Proce;

public interface IProceService {

	void save(Proce proce);
	void delete(Long id);
	List<Proce> getAllProces();
	Proce getProceById(Long id);
	List<Proce> getContainsSujetProce(String SujetProce);
	Proce getProceBysujetProce(String sujetProce);
}
