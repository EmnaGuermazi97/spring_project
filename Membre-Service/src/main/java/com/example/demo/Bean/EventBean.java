package com.example.demo.Bean;

import java.time.LocalDate;
import lombok.Data;

public class EventBean {
	Long id;
	String title;
	LocalDate date;
	String location;
	public EventBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventBean(Long id, String title, LocalDate date, String location) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
