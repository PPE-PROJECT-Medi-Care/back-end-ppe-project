package com.example.td1.Model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
public class Departement{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idDepartement;
	
	private String nomDepartement;
	
	@OneToMany (mappedBy="iddepartement", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Etudiant> etudiants;

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
   @JsonIgnore
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
   @JsonIgnore
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Departement(String nomDepartement) {
		super();
		this.nomDepartement = nomDepartement;
	}

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}