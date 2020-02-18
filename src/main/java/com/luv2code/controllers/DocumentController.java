package com.luv2code.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.domain.AvocatVo;
import com.luv2code.entities.Document;
import com.luv2code.entities.Proce;
import com.luv2code.entities.TypeProce;
import com.luv2code.service.IDocumentService;
import com.luv2code.service.IProceService;

@Controller
@RequestMapping("/Doc")
public class DocumentController {

	@Autowired
	IDocumentService DocService;

	@Autowired
	IProceService proceService;
	
	@RequestMapping ("/list")
	public String ListProce(Model m) {
		List<Document> listDocs= DocService.getAllDocs();
		m.addAttribute("listDocs", listDocs);
		
		return "Doc/viewDocs";
	}
	
	@RequestMapping(value = "/save")
	public String save(Model m,@ModelAttribute("Doc") Document Doc) {
		List<Proce> listProce= proceService.getAllProces();
		m.addAttribute("listProce", listProce);
		DocService.save(Doc);
		return "redirect:/Doc/list";
	}
	
	@RequestMapping("/form")
	public String showform(Model m) {
		List<Proce> listProce= proceService.getAllProces();
		m.addAttribute("listProce", listProce);
		
		m.addAttribute("Doc", new Document());
		return "/Doc/editDoc";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		Document Doc = DocService.getDocumentById(id);
		
		m.addAttribute("Doc", Doc);
		return "/Doc/editDoc";
	}
	
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("Doc") Document Doc) {
		DocService.save(Doc);
		return "redirect:/Doc/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		DocService.delete(id);
		return "redirect:/Doc/list";
	}

	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String Recherche(Model m, @RequestParam(value = "sujetDoc") String sujetDoc) {
		List<Document> listDocs = DocService.getDocumentsujetContains(sujetDoc);
		m.addAttribute("listDocs", listDocs);
		return "/Doc/viewDocs";

	}
}
