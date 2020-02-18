package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.Document;

public interface IDocumentService {

	void save(Document doc);
	void delete(Long id);
	List<Document> getDocumentsujetContains(String nomDoc);
	List<Document> getAllDocs();
	Document getDocumentById(Long id);
}
