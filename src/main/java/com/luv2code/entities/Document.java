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
public class Document {

			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private long numDoc;
			private String nomDoc;
			private String sujetDoc;
			
			
			@ManyToOne(fetch=FetchType.LAZY)
			@JoinColumn(name="proce_id")
			private Proce proce;


			public Document(String nomDoc, String sujetDoc, Proce proce) {
				super();
				this.nomDoc = nomDoc;
				this.sujetDoc = sujetDoc;
				this.proce = proce;
			}


			
			
}
