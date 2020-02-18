package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entities.Proce;
import com.luv2code.entities.Seance;

public interface SeanceRepository extends JpaRepository<Seance,Long> {

	List<Seance> findAll();
	 List<Seance> findByProceContaining(Proce proce);
	Seance getSeanceByProce(Proce proce);

}
