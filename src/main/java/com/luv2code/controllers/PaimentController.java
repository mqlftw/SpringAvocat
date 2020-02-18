package com.luv2code.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luv2code.entities.Paiment;
import com.luv2code.entities.Proce;
import com.luv2code.service.IPaimentService;
import com.luv2code.service.IProceService;

@Controller
@RequestMapping("/Paiment")
public class PaimentController {

	@Autowired
	IPaimentService paimentService;

	@Autowired
	IProceService proceService;
	
	@RequestMapping ("/list")
	public String ListProce(Model m) {
		List<Paiment> listPaiment= paimentService.getAllPaiments();
		m.addAttribute("listPaiment", listPaiment);
		
		return "Paiment/viewPaiments";
	}
	
	@RequestMapping(value = "/save")
	public String save(Model m,@ModelAttribute("Paiment") Paiment paiment) {
		
		paimentService.save(paiment);
		return "redirect:/Paiment/list";
	}
	
	@RequestMapping("/form")
	public String showform(Model m) {
		List<Proce> listProce= proceService.getAllProces();
		m.addAttribute("listProce", listProce);
		m.addAttribute("Paiment", new Paiment());
		return "/Paiment/editPaiment";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		List<Proce> listProce= proceService.getAllProces();
		m.addAttribute("listProce", listProce);
		Paiment paiment = paimentService.getPaimentById(id);
		
		m.addAttribute("Paiment", paiment);
		return "/Paiment/editPaiment";
	}
	
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("Paiment") Paiment paiment) {
		
		paimentService.save(paiment);
		return "redirect:/Paiment/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		paimentService.delete(id);
		return "redirect:/Paiment/list";
	}

	
}
