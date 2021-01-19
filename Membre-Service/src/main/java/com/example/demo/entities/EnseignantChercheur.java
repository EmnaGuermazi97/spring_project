package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.demo.Bean.PublicationBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("enseignant")
public class EnseignantChercheur extends Membre implements Serializable{
	private String etablissement;
	private String grade;
	
	
	public EnseignantChercheur( String cin, String nom, String prenom, Date dateNaissance, String cv,
			String email, String password, String etablissement, String grade) {
		super( cin, nom, prenom, dateNaissance, cv, email, password);
		this.etablissement = etablissement;
		this.grade = grade;
	}
	
	@OneToMany(mappedBy = "encadrant")
	@JsonIgnore
	private Collection<Etudiant> etudiants;


	public EnseignantChercheur() {
		super();
	}

	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo,
			String email, String password, Collection<PublicationBean> pubs) {
		super(cin, nom, prenom, dateNaissance, cv, photo, email, password, pubs);
	}

	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv, String email,
			String password) {
		super(cin, nom, prenom, dateNaissance, cv, email, password);
	}
	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String email) {
		super(cin, nom, prenom, dateNaissance,email);
	}


	public EnseignantChercheur(String etablissement, String grade) {
		super();
		this.etablissement = etablissement;
		this.grade = grade;
	}

	public EnseignantChercheur(String etablissement, String grade, Collection<Etudiant> etudiants) {
		super();
		this.etablissement = etablissement;
		this.grade = grade;
		this.etudiants = etudiants;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
}
