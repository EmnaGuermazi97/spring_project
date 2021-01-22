package tn.enis.tool.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	LocalDate date;
	@Column(unique=true)
	String source;
	public Tool() {
		super();
	}
	
	public Tool(LocalDate date, String source) {
		super();
		this.date = date;
		this.source = source;
	}

	public Tool(Long id, LocalDate date, String source) {
		super();
		this.id = id;
		this.date = date;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	

}
