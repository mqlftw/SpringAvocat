package com.luv2code.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProduitVo {

	
	private long idProduit;
	private String nomProduit;
	private String Description;
	private double prixHT;
	private double prixTTC;
	public ProduitVo(String nomProduit, String description, double prixHT, double prixTTC) {
		super();
		this.nomProduit = nomProduit;
		Description = description;
		this.prixHT = prixHT;
		this.prixTTC = prixTTC;
	}
	
	
	
	
	
	


	
	
}
