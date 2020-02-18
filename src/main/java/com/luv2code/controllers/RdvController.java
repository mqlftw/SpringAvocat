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
import com.luv2code.entities.Client;
import com.luv2code.entities.RDV;
import com.luv2code.entities.User;
import com.luv2code.service.IAvocatService;
import com.luv2code.service.IClientService;
import com.luv2code.service.IUserService;
import com.luv2code.service.RdvService;

@Controller
@RequestMapping("/RDV")
public class RdvController {

	@Autowired
	IUserService userService;

	@Autowired
	IAvocatService avocatService;
	
	@Autowired
	RdvService rdvService;
	
	@Autowired
	IClientService clientService;

	@RequestMapping(value = "/list")
	public String show(Model m) {

		List<RDV> listRdv = rdvService.getRDV();
		m.addAttribute("listRdv", listRdv);
		return "/RDV/viewRDV";

	}

	@RequestMapping(value = "/save")
	public String save(Model m, @ModelAttribute("RDV") RDV rdv) {
		rdv.setEtatRDV(true);
		rdvService.save(rdv);
		return "redirect:/RDV/list";
	}

	@RequestMapping("/form")
	public String showform(Model m) {
		List<AvocatVo> listAvocat = avocatService.getAvocats();
		List<Client> listClients= clientService.GetAllClients();

		m.addAttribute("listClients", listClients);
		m.addAttribute("listAvocat", listAvocat);
		m.addAttribute("RDV", new RDV());
		return "/RDV/editRDV";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		RDV rdv = rdvService.getRDVbyId(id);
		List<Client> listClients= clientService.GetAllClients();
		List<AvocatVo> listAvocat = avocatService.getAvocats();
		m.addAttribute("listClients", listClients);
		m.addAttribute("listAvocat", listAvocat);
		m.addAttribute("RDV", rdv);
		return "/RDV/editRDV";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("RDV") RDV rdv) {
		rdvService.save(rdv);
		return "redirect:/RDV/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		rdvService.delete(id);
		return "redirect:/RDV/list";
	}

	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String Recherche(Model m, @RequestParam(value = "sujetRDV") String sujetRDV) {
		List<RDV> listRDV = rdvService.findBysujetRDV(sujetRDV);
		m.addAttribute("listRdv", listRDV);
		return "/RDV/viewRDV";

	}
}
