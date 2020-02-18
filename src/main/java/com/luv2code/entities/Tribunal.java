package com.luv2code.entities;

import java.util.HashSet;
import java.util.Set;

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
public class Tribunal {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numTribunal;
	private String typeTribunal;
	private String lieuTribunal;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tribunal")
	private Set<Seance> seances= new HashSet<>();


	public Tribunal(String typeTribunal, String lieuTribunal, Set<Seance> seances) {
		this.typeTribunal = typeTribunal;
		this.lieuTribunal = lieuTribunal;
		this.seances = seances;
	}
	
	
}
