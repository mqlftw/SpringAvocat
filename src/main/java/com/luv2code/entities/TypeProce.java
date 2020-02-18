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

public class TypeProce {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long numTypeProce;
	private String nomTypeProce;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="typeProce")
	private Set<Proce> proce = new HashSet<>();
	


	public TypeProce(String nomTypeProce, Set<Proce> proce) {
		this.nomTypeProce = nomTypeProce;
		this.proce = proce;
	}


	
	
	
	
}
