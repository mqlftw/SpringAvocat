package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.DocumentRepository;
import com.luv2code.entities.Document;

@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	DocumentRepository docRepo;
	
	@Override
	public void save(Document doc) {
		docRepo.save(doc);
		
	}

	@Override
	public void delete(Long id) {
		docRepo.deleteById(id);
	}

	@Override
	public List<Document> getDocumentsujetContains(String sujetDoc) {
		return docRepo.findBysujetDocContaining(sujetDoc);
	}

	@Override
	public List<Document> getAllDocs() {
			return docRepo.findAll();
			}

	@Override
	public Document getDocumentById(Long id) {
		return docRepo.getOne(id);
	}

}
