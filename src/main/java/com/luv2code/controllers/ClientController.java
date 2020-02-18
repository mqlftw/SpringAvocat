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

import com.luv2code.entities.Client;

import com.luv2code.service.IClientService;

@Controller
@RequestMapping("/Client")
public class ClientController {

	@Autowired
	IClientService clientService;

	@RequestMapping (value="/list")
	public String show(Model m) {
		
		List<Client> listClients= clientService.GetAllClients();
		m.addAttribute("listClients", listClients);
		return "/Client/viewClients";
		
	}

	@RequestMapping(value = "/save")
	public String save(Model m, @ModelAttribute("Client") Client client) {

		clientService.save(client);
		return "redirect:/Client/list";
	}

	@RequestMapping("/form")
	public String showform(Model m) {
		m.addAttribute("Client", new Client());
		return "/Client/editClient";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		Client client = clientService.getClientById(id);
		m.addAttribute("Client", client);
		return "/Client/editClient";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("Client") Client client) {
		clientService.save(client);
		return "redirect:/Client/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		clientService.delete(id);
		return "redirect:/Client/list";
	}

	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String Recherche(Model m, @RequestParam(value = "nomClient") String nomClient) {
		List<Client> listClients = clientService.getClientsContains(nomClient);
		m.addAttribute("listClients", listClients);
		return "/Client/viewClients";

	}
}
