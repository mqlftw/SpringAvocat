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

import com.luv2code.entities.Proce;
import com.luv2code.entities.Tribunal;
import com.luv2code.service.IProceService;
import com.luv2code.service.ITribunalService;

@Controller
@RequestMapping ("/Tribunal")
public class TribunalController {

	@Autowired
	ITribunalService tribunalService;

	
	@Autowired
	IProceService proceService;
	

	@RequestMapping(value = "/list")
	public String show(Model m) {

		List<Tribunal> listTribunal = tribunalService.getAllTribunals();
		m.addAttribute("listTribunal", listTribunal);
		return "/Tribunal/viewTribunals";

	}

	@RequestMapping(value = "/save")
	public String save(Model m, @ModelAttribute("Tribunal") Tribunal tribunal) {
		List<Proce> listProce= proceService.getAllProces();
		m.addAttribute("listProce", listProce);
		tribunalService.save(tribunal);
		return "redirect:/Tribunal/list";
	}

	@RequestMapping("/form")
	public String showform(Model m) {
		
		m.addAttribute("Tribunal", new Tribunal());
		return "/Tribunal/editTribunal";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		
		Tribunal tribunal = tribunalService.getTribunalById(id);
		
		m.addAttribute("Tribunal", tribunal);
		return "/Tribunal/editTribunal";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("Tribunal") Tribunal tribunal) {
		tribunalService.save(tribunal);
		return "redirect:/Tribunal/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		tribunalService.delete(id);
		return "redirect:/Tribunal/list";
	}

	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String Recherche(Model m, @RequestParam(value = "lieuTribunal") String lieuTribunal) {
		List<Tribunal> listTribunal = tribunalService.findBylieuTribunal(lieuTribunal);
		m.addAttribute("listTribunal", listTribunal);
		return "/Tribunal/viewTribunals";

	}
}
