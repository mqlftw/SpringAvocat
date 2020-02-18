package com.luv2code.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Paiment {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long numPaiment;
		private String typePaiment;
		private float tarif;
		
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="proce_id")
		private Proce proce;


		public Paiment(String typePaiment, float tarif, Proce proce) {
			super();
			this.typePaiment = typePaiment;
			this.tarif = tarif;
			this.proce = proce;
		}
		
		
		
		
		
}
