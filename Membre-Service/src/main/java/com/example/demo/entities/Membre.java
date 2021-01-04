package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.Bean.PublicationBean;
import com.example.demo.Bean.EventBean;
import com.example.demo.Bean.ToolBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_mbr", discriminatorType = DiscriminatorType.STRING,length = 3)

public  abstract class Membre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cin;
	
	private String nom;
	
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	private String cv;
	
	private byte[] photo;
	
	private String email;
	
	private String password;
	@Transient
	Collection<PublicationBean> pubs;
	@Transient
	List<ToolBean> tools;
	@Transient
	List<EventBean> events;
	public Membre() {
		super();
	}
	public Membre(String cin, String nom, String prenom, Date dateNaissance, String email, String password) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
	}
	public Membre(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo, String email,
			String password, Collection<PublicationBean> pubs) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.cv = cv;
		this.photo = photo;
		this.email = email;
		this.password = password;
		this.pubs = pubs;
	}

	public Membre(String cin, String nom, String prenom, Date dateNaissance, String cv, String email, String password) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.cv = cv;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<PublicationBean> getPubs() {
		return pubs;
	}
	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}
	
	
}
