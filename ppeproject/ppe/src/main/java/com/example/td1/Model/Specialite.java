package com.example.td1.Model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
public class Specialite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idSpecialite;
	
	private String libelleSpecialite;
	
	@OneToMany (mappedBy="idspecialite", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Etudiant> etudiants;

	public Long getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(Long idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getLibelleSpecialite() {
		return libelleSpecialite;
	}

	public void setLibelleSpecialite(String libelleSpecialite) {
		this.libelleSpecialite = libelleSpecialite;
	}
    @JsonIgnore
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
   @JsonIgnore
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Specialite(String libelleSpecialite) {
		super();
		this.libelleSpecialite = libelleSpecialite;
	}

	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
