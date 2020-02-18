package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.luv2code.dao.AvocatRepository;
import com.luv2code.domain.AvocatConverter;
import com.luv2code.domain.AvocatVo;
import com.luv2code.entities.Avocat;

@Service
public class AvocatServiceImpl implements IAvocatService {
	@Autowired
	private AvocatRepository avocatRepository;

	@Override
	public List<AvocatVo> getAvocats() {
		List<Avocat> list = avocatRepository.findAll();
		return AvocatConverter.toListVo(list);
	}

	@Override
	public void save(AvocatVo avocatVo) {
		avocatRepository.save(AvocatConverter.toBo(avocatVo));
	}
	
	@Override
	public AvocatVo getAvocatById(Long id) {
		boolean trouve = avocatRepository.existsById(id);
		if (!trouve)
			return null;
		return AvocatConverter.toVo(avocatRepository.getOne(id));
	}

	@Override
	public void delete(Long id) {
		avocatRepository.deleteById(id);
	}

	@Override
	public List<AvocatVo> findAll(int pageId, int size) {
		Page<Avocat> result = avocatRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return AvocatConverter.toListVo(result.getContent());
	}

	@Override
	public List<AvocatVo> sortBy(String fieldName) {
		return AvocatConverter.toListVo(avocatRepository.findAll(Sort.by(fieldName)));
	}

	@Override
	public List<Avocat> findBynomAvocat(String nomAvocat) {
		return avocatRepository.findBynomAvocatContaining(nomAvocat);
	}

	

	
	

}
