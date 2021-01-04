package com.example.demo.Bean;

import java.time.LocalDate;

public class ToolBean {
	Long id;
	LocalDate date;
	String source;
	public ToolBean() {
		super();
	}
	public ToolBean(Long id, LocalDate date, String source) {
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
