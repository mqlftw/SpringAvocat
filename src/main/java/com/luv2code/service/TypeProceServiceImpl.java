package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.TypeProceRepository;
import com.luv2code.entities.TypeProce;

@Service
public class TypeProceServiceImpl implements TypeProceService{

	@Autowired
	TypeProceRepository TypeProceRepo;

	
	@Override
	public List<TypeProce> GetAllTypeProces() {
		return TypeProceRepo.findAll();
	}

}
