package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.PublicationBean;



@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Membre implements Serializable{
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private String sujet;
	private String diplome;
	
	
	@ManyToOne
	private EnseignantChercheur encadrant;
	

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Etudiant(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo, String email,
			String password, Collection<PublicationBean> pubs) {
		super(cin, nom, prenom, dateNaissance, cv, photo, email, password, pubs);
		// TODO Auto-generated constructor stub
	}


	public Etudiant(String cin, String nom, String prenom, Date dateNaissance, String email, String password) {
		super(cin, nom, prenom, dateNaissance, email, password);
		// TODO Auto-generated constructor stub
	}

	public Etudiant(Date dateInscription, String sujet, String diplome, EnseignantChercheur encadrant) {
		super();
		this.dateInscription = dateInscription;
		this.sujet = sujet;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}


	public Etudiant( String cin, String nom, String prenom, Date dateNaissance, String cv,
			String email, String password, Date dateInscription, String sujet, String diplome,
			EnseignantChercheur encadrant) {
		super( cin, nom, prenom, dateNaissance, cv,  email, password);
		this.dateInscription = dateInscription;
		this.sujet = sujet;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}


	public Date getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public String getDiplome() {
		return diplome;
	}


	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}


	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}


	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}
}
