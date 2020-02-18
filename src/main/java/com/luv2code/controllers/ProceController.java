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
import com.luv2code.entities.Proce;
import com.luv2code.entities.TypeProce;
import com.luv2code.service.IAvocatService;
import com.luv2code.service.IProceService;
import com.luv2code.service.TypeProceService;

@Controller
@RequestMapping("/Proce")
public class ProceController {
	
	@Autowired
	IProceService proceService;
	
	@Autowired
	IAvocatService avocatService;
	
	@Autowired
	TypeProceService typeProceService;
	
	@RequestMapping ("/list")
	public String ListProce(Model m) {
		List<Proce> listProce= proceService.getAllProces();
		m.addAttribute("listProce", listProce);
		
		return "Proce/viewProce";
	}
	
	@RequestMapping(value = "/save")
	public String save(Model m,@ModelAttribute("Proce") Proce proce) {
		List<AvocatVo> listAvocat = avocatService.getAvocats();
		List<TypeProce> listTypeProce= typeProceService.GetAllTypeProces();
		m.addAttribute("listTypeProce", listTypeProce);
		m.addAttribute("listAvocat", listAvocat);
		proceService.save(proce);
		return "redirect:/Proce/list";
	}
	
	@RequestMapping("/form")
	public String showform(Model m) {
		List<AvocatVo> listAvocat = avocatService.getAvocats();
		List<TypeProce> listTypeProce= typeProceService.GetAllTypeProces();
		m.addAttribute("listTypeProce", listTypeProce);
		m.addAttribute("listAvocat", listAvocat);
		m.addAttribute("Proce", new Proce());
		return "/Proce/editProce";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		Proce proce = proceService.getProceById(id);
		
		m.addAttribute("Proce", proce);
		return "/Proce/editProce";
	}
	
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("Proce") Proce proce) {
		proceService.save(proce);
		return "redirect:/Proce/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		proceService.delete(id);
		return "redirect:/Proce/list";
	}

	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String Recherche(Model m, @RequestParam(value = "sujetProce") String sujetProce) {
		List<Proce> listProce = proceService.getContainsSujetProce(sujetProce);
		m.addAttribute("listProce", listProce);
		return "/Proce/viewProce";

	}

}
