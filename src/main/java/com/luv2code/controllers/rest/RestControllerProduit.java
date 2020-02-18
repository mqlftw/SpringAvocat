package com.luv2code.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.domain.ProduitVo;
import com.luv2code.service.IProduitService;


@RestController
public class RestControllerProduit {

	
    @Autowired
    private IProduitService service;
 
    /**
     * Pour chercher tous les emplyés
     */
    @GetMapping(value = "/rest/produit", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<ProduitVo> getAll() {
        return service.getProduits();
    }
 
    /**
     * Pour chercher un employé par son id
     */
    @GetMapping(value = "/rest/produit/{id}")
    public ResponseEntity<Object>  getProduitById(@PathVariable(value = "id") Long ProduitVoId) {
    	ProduitVo ProduitVoFound = service.getProduitById(ProduitVoId);
        if (ProduitVoFound == null)
            return new ResponseEntity<>("Product doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(ProduitVoFound, HttpStatus.OK);
    }
 
    /**
     * Pour créer un nouveau employé
     */
    @PostMapping(value = "/rest/produit")
    public ResponseEntity<Object> createAvocat(@Valid @RequestBody ProduitVo produitVo) {
        service.save(produitVo);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
 
    /**
     * Pour modifier un produit par son id
     */
    @PutMapping(value = "/rest/produit/{id}")
    public ResponseEntity<Object> updateAvocat(@PathVariable(name = "id") Long ProduitVoID, @RequestBody ProduitVo produitVo) {
    	ProduitVo ProduitFound = service.getProduitById(ProduitVoID);
        if (ProduitFound == null)
            return new ResponseEntity<>("Product doen't exist", HttpStatus.OK);
        produitVo.setIdProduit(ProduitVoID);
        service.save(produitVo);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }
 
    /**
     * Pour supprimer un employé par son id
     */
    @DeleteMapping(value = "/rest/produit/{id}")
    public ResponseEntity<Object> deleteAvocat(@PathVariable(name = "id") Long ProduitVoID) {
        ProduitVo ProduitFound = service.getProduitById(ProduitVoID);
        if (ProduitFound == null)
            return new ResponseEntity<>("Produit doen't exist", HttpStatus.OK);
        service.delete(ProduitVoID);
        return new ResponseEntity<>("Produit is deleted successsfully", HttpStatus.OK);
    }
   
    /**
     * Pour chercher tous les emplyés
     */
    @GetMapping(value = "/rest/sort/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<ProduitVo> sortBy(@PathVariable String fieldName) {
        return service.sortBy(fieldName);
    }
   
    /**
     * Afficher la liste des employés en utilisant la pagination
     */
    @GetMapping("/rest/pagination/{pageid}/{size}")
    public List<ProduitVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return service.findAll(pageid, size);
    }
}
