package com.luv2code.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Produit {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idProduit;
	
	private String nomProduit;
	private String Description;
	private double prixHT;
	private double prixTTC;
	public Produit(String nomProduit, String description, double prixHT, double prixTTC) {
		super();
		this.nomProduit = nomProduit;
		Description = description;
		this.prixHT = prixHT;
		this.prixTTC = prixTTC;
	}
	
	

	

	
		
}
