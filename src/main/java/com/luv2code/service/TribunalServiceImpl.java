package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.TribunalRepository;
import com.luv2code.entities.Tribunal;

@Service
public class TribunalServiceImpl implements ITribunalService {

	
	@Autowired
	TribunalRepository tribunalRepo;

	@Override
	public List<Tribunal> getAllTribunals() {
		return tribunalRepo.findAll();
		}

	@Override
	public void save(Tribunal tribunal) {
		tribunalRepo.save(tribunal);
	}

	@Override
	public void delete(Long id) {
		tribunalRepo.deleteById(id);
	}

	@Override
	public Tribunal getTribunalById(Long id) {
		return tribunalRepo.getOne(id);
	}

	@Override
	public List<Tribunal> findBylieuTribunal(String lieuTribunal) {
		return tribunalRepo.findBylieuTribunalContaining(lieuTribunal);
	}
}
