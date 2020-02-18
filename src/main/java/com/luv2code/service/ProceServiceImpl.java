package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.ProceRepository;
import com.luv2code.entities.Proce;


@Service
public class ProceServiceImpl implements IProceService{

	@Autowired
	ProceRepository ProceRepo;
	@Override
	public void save(Proce proce) {
		ProceRepo.save(proce);
	}
	@Override
	public void delete(Long id) {
		ProceRepo.deleteById(id);
	}
	@Override
	public List<Proce> getAllProces() {

		return ProceRepo.findAll();
	}
	@Override
	public Proce getProceById(Long id) {
		return ProceRepo.getOne(id);
	}
	
	
	@Override
	public List<Proce> getContainsSujetProce(String SujetProce) {
		return ProceRepo.findBysujetProceContaining(SujetProce);
	}
	@Override
	public Proce getProceBysujetProce(String sujetProce) {
		return ProceRepo.findBysujetProce(sujetProce);
	}
}