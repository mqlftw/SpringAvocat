package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.SeanceRepository;
import com.luv2code.entities.Proce;
import com.luv2code.entities.Seance;

@Service
public class SeanceServiceImpl implements ISeanceService {

	@Autowired
	SeanceRepository seanceRepo;
	
	@Override
	public List<Seance> getAllSeances() {
		return seanceRepo.findAll();
	}

	@Override
	public void save(Seance seance) {

		seanceRepo.save(seance);
	}

	@Override
	public void delete(Long id) {
		seanceRepo.deleteById(id);
	}

	@Override
	public Seance getSeanceById(Long id) {
		return seanceRepo.getOne(id);
	}

	@Override
	public Seance getSeanceByProce(Proce proce) {
		return seanceRepo.getSeanceByProce(proce);
	}

}
