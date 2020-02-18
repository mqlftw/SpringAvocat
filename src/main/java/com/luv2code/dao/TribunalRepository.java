package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Tribunal;

public interface TribunalRepository extends JpaRepository<Tribunal,Long> {

	List<Tribunal> findAll();
	public List<Tribunal> findBylieuTribunalContaining(String lieuTribunal);

}
