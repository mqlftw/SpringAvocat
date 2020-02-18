package com.luv2code.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvocatVo {

	
	private long numAvocat;
	private String nomAvocat;
	private String prenomAvocat;
	private String telAvocat;
	private double salaire;
	
	
	
	public AvocatVo(long numAvocat, String nomAvocat, String prenomAvocat, String telAvocat, double salaire) {
		this.numAvocat = numAvocat;
		this.nomAvocat = nomAvocat;
		this.prenomAvocat = prenomAvocat;
		this.telAvocat = telAvocat;
		this.salaire = salaire;
	}
	
	


	
	
}
