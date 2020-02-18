package com.luv2code.entities;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	
@Data	
@NoArgsConstructor
public class Seance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numSeance;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSeance;
	private LocalTime heurSeance;
	private int Nbrjudge;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "proce_id")
	private Proce proce;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tribunal_id")
	private Tribunal tribunal;


	public Seance(Date dateSeance, LocalTime heurSeance, int nbrjudge, Proce proce, Tribunal tribunal) {
		this.dateSeance = dateSeance;
		this.heurSeance = heurSeance;
		this.Nbrjudge = nbrjudge;
		this.proce = proce;
		this.tribunal = tribunal;
	}
	
	
	
}
