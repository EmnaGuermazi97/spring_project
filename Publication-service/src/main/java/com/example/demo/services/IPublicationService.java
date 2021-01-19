package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Publication;
public interface IPublicationService {
	List<Publication> findAll();

	Publication getById(Long id);

	Publication add(Publication tool);

	void delete(Long id);

	Publication update(Publication member);
}
