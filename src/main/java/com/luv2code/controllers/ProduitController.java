package com.luv2code.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.domain.ProduitVo;
import com.luv2code.service.IProduitService;

@Controller
public class ProduitController {

	@Autowired
    private IProduitService service;
	
	@RequestMapping("/")
    public String index(Model m) {
        return "index";
    }
	/*
	  @RequestMapping(value = "/save")
	    public String save(@ModelAttribute("produitVo") ProduitVo produit) {
	        service.save(produit);
	        return "redirect:/list"; // will redirect to viewemp request mapping
	    }
	  
	  @RequestMapping("/form")
	    public String showform(Model m) {
	        m.addAttribute("produitVo", new ProduitVo());
	        return "edit";
	    }
	  
	  @RequestMapping("/list")
	    public String viewemp(Model m) {
	        List<ProduitVo> list = service.getProduits();
	        m.addAttribute("list", list);
	        return "viewProduit";
	    }
	  
	  @RequestMapping(value = "/edit/{id}")
	    public String edit(@PathVariable Long id, Model m) {
	        ProduitVo produit = service.getProduitById(id);
	        m.addAttribute("produitVo", produit);
	        return "edit";
	    }
	 
	    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
	    public String editsave(@ModelAttribute("produitVo") ProduitVo produit) {
	        service.save(produit);
	        return "redirect:/list";
	    }
	 
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable Long id) {
	        service.delete(id);
	        return "redirect:/list";
	    }
	    /*
	    @RequestMapping (value = "/Recherche", method= RequestMethod.GET)
	    public String Recherche(Model m , @RequestParam(defaultValue="amine") String nomAvocat) {
	    	List <Avocat> List =service.findBynomAvocat(nomAvocat);
	    	m.addAttribute("list",List);
	    	return "redirect:/list";
	    	
	    }
	    */
}
