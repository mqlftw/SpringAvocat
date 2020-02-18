package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.domain.AvocatVo;
import com.luv2code.entities.Avocat;


public interface AvocatRepository extends JpaRepository<Avocat, Long> {
	 	List<AvocatVo> findBySalaire(double salaire);
	 	List<AvocatVo> findBynomAvocat(String nomAvocat);
		List<Avocat> findBynomAvocatLike(String string);
	 	List<Avocat> findBynomAvocatContaining(String nomAvocat);

	 
}
