package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.domain.ProduitVo;
import com.luv2code.entities.Produit;



public interface ProduitRepository extends JpaRepository<Produit, Long> {
	 	List<ProduitVo> findByidProduit(long idProduit);
	 	List<ProduitVo> findBynomProduit(String nomProduit);
		List<ProduitVo> findBynomProduitLike(String string);
	 
}
