package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.PaimentRepository;
import com.luv2code.entities.Paiment;

@Service
public class PaimentServiceImpl implements IPaimentService {

	@Autowired
	PaimentRepository paimentRepo;
	
	@Override
	public void save(Paiment paiment) {
		paimentRepo.save(paiment);
	}

	@Override
	public void delete(Long id) {
		paimentRepo.deleteById(id);
	}

	@Override
	public List<Paiment> getAllPaiments() {
		return paimentRepo.findAll();
		}

	@Override
	public Paiment getPaimentById(Long id) {
		return paimentRepo.getOne(id);
	}
}
