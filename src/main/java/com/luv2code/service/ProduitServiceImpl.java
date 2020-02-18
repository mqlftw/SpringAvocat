package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.luv2code.dao.ProduitRepository;
import com.luv2code.domain.ProduitConverter;
import com.luv2code.domain.ProduitVo;
import com.luv2code.entities.Produit;

@Service
public class ProduitServiceImpl implements IProduitService {
	@Autowired
	private ProduitRepository ProduitRepository;

	@Override
	public List<ProduitVo> getProduits() {
		List<Produit> list = ProduitRepository.findAll();
		return ProduitConverter.toListVo(list);
	}

	@Override
	public void save(ProduitVo produitVo) {
		ProduitRepository.save(ProduitConverter.toBo(produitVo));
	}

	@Override
	public ProduitVo getProduitById(Long id) {
		boolean trouve = ProduitRepository.existsById(id);
		if (!trouve)
			return null;
		return ProduitConverter.toVo(ProduitRepository.getOne(id));
	}

	@Override
	public void delete(Long id) {
		ProduitRepository.deleteById(id);
	}

	@Override
	public List<ProduitVo> findAll(int pageId, int size) {
		Page<Produit> result = ProduitRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return ProduitConverter.toListVo(result.getContent());
	}

	@Override
	public List<ProduitVo> sortBy(String fieldName) {
		return ProduitConverter.toListVo(ProduitRepository.findAll(Sort.by(fieldName)));
	}

	

	

}
