package com.luv2code.service;

import java.util.List;

import com.luv2code.domain.ProduitVo;

public interface IProduitService {
	List<ProduitVo> getProduits();
	void save(ProduitVo produit);
	
	ProduitVo getProduitById(Long id);
	void delete(Long id);
	//Pour la pagination
	List<ProduitVo> findAll(int pageId, int size);
	//pour le tri
	List<ProduitVo> sortBy(String fieldName);
}
