package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.RDVRepository;
import com.luv2code.entities.RDV;

@Service
public class RdvServiceImpl implements RdvService {

	@Autowired
	RDVRepository rdvRepo;
	
	@Override
	public void save(RDV rdv) {
		
		rdvRepo.save(rdv);
	}

	@Override
	public void delete(Long id) {
			rdvRepo.deleteById(id);
	}

	@Override
	public List<RDV> getRDV() {
		return rdvRepo.findAll();
	}

	@Override
	public RDV getRDVbyId(Long id) {
		return rdvRepo.getOne(id);
	}

	@Override
	public List<RDV> findBysujetRDV(String sujetRDV) {
		return rdvRepo.findBysujetRDVContaining(sujetRDV);
	}

}
