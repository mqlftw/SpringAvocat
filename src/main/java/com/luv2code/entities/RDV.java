package com.luv2code.entities;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
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
public class RDV {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numRDV;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateRDV;
	
	private LocalTime heureRDV;
	private String sujetRDV;
	private boolean etatRDV;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "Client_id")
	private Client client;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "avocat_id")
	private Avocat Avocat;

	public RDV(Date dateRDV, LocalTime heureRDV, String sujetRDV, boolean etatRDV, Client client,
			Avocat avocat) {
		this.dateRDV = dateRDV;
		this.heureRDV = heureRDV;
		this.sujetRDV = sujetRDV;
		this.etatRDV = etatRDV;
		this.client = client;
		this.Avocat = avocat;
	}
	
	
	
	
	
	
	
}
