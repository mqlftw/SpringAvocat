package com.luv2code.service;

import java.util.List;

import com.luv2code.domain.AvocatVo;
import com.luv2code.entities.Avocat;

public interface IAvocatService {
	List<AvocatVo> getAvocats();
	void save(AvocatVo avocat);
	
	AvocatVo getAvocatById(Long id);
	void delete(Long id);
	//Pour la pagination
	List<AvocatVo> findAll(int pageId, int size);
	//pour le tri
	List<AvocatVo> sortBy(String fieldName);
	List<Avocat> findBynomAvocat(String nomAvocat);

}
