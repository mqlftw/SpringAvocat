package com.luv2code.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.entities.Proce;
import com.luv2code.entities.Seance;
import com.luv2code.entities.Tribunal;
import com.luv2code.service.IProceService;
import com.luv2code.service.ISeanceService;
import com.luv2code.service.ITribunalService;

@Controller
@RequestMapping("/Seance")
public class SeanceController {

	@Autowired
	ISeanceService seanceService;
	
	
	@Autowired
	ITribunalService tribunalService;
	
	@Autowired
	IProceService proceService;
	@RequestMapping(value = "/list")
	public String show(Model m) {

		List<Seance> listSeance = seanceService.getAllSeances();
		m.addAttribute("listSeance", listSeance);
		return "/Seance/viewSeances";

	}

	@RequestMapping(value = "/save")
	public String save(Model m, @ModelAttribute("Seance") Seance seance) {	
		seanceService.save(seance);
		return "redirect:/Seance/list";
	}

	@RequestMapping("/form")
	public String showform(Model m) {
		List<Proce> listProce= proceService.getAllProces();
		List<Tribunal> listTribunal= tribunalService.getAllTribunals();
		System.out.println(listProce.size()+listTribunal.size());
		m.addAttribute("listProce", listProce);
		m.addAttribute("listTribunal", listTribunal);
		m.addAttribute("Seance", new Seance());
		return "/Seance/editSeance";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		List<Proce> listProce= proceService.getAllProces();
		List<Tribunal> listTribunal= tribunalService.getAllTribunals();
		m.addAttribute("listProce", listProce);
		m.addAttribute("listTribunal", listTribunal);
		
		Seance seance = seanceService.getSeanceById(id);
		
		m.addAttribute("Seance", seance);
		return "/Seance/editSeance";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("Seance") Seance seance) {
		seanceService.save(seance);
		return "redirect:/Seance/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		seanceService.delete(id);
		return "redirect:/Seance/list";
	}
	
	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String Recherche(Model m, @RequestParam(value = "sujetProce") String sujetProce) {
		List<Proce> listProce= proceService.getContainsSujetProce(sujetProce);
		List<Seance> listSeance = new ArrayList<>();
		for(Proce proce : listProce) {
			Seance e =seanceService.getSeanceByProce(proce);
			listSeance.add(e);
		}
		m.addAttribute("listSeance", listSeance);
		return "/Seance/viewSeances";

	}
}
