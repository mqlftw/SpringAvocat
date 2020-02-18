package com.luv2code.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Avocat {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numAvocat;
	
	private String nomAvocat;
	private String prenomAvocat;
	private String telAvocat;
	private double salaire;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="Avocat",cascade = CascadeType.ALL)
	private Set <Proce> proce = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="Avocat",cascade = CascadeType.ALL)
	private Set <RDV> rdv = new HashSet<>();

	public Avocat(String nomAvocat, String prenomAvocat, String telAvocat, double salaire, Set<Proce> proce,
			Set<RDV> rdv) {
		super();
		this.nomAvocat = nomAvocat;
		this.prenomAvocat = prenomAvocat;
		this.telAvocat = telAvocat;
		this.salaire = salaire;
		this.proce = proce;
		this.rdv = rdv;
	}
	public Avocat(String nomAvocat, String prenomAvocat, String telAvocat, double salaire)
	{
		super();
		this.nomAvocat = nomAvocat;
		this.prenomAvocat = prenomAvocat;
		this.telAvocat = telAvocat;
		this.salaire = salaire;
	}

	
		
}
