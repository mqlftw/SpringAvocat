package com.luv2code.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Proce {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long numProce;
	
	
	private String sujetProce;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "avocat_id")
	private Avocat Avocat;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="proce")
	private Set<Paiment> paiment = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="proce")
	private Set<Seance> seances = new HashSet<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "typeProce_id")
	private TypeProce typeProce;

	public Proce(String sujetProce, Avocat avocat, Set<Paiment> paiment, Set<Seance> seances, TypeProce typeProce) {
		super();
		this.sujetProce = sujetProce;
		this.Avocat = avocat;
		this.paiment = paiment;
		this.seances = seances;
		this.typeProce = typeProce;
	}
	
	


	
	
	
	
	
	
	
	
	
}
