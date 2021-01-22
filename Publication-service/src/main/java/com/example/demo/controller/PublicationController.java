package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Publication;
import com.example.demo.services.IPublicationService;


@RestController
@RequestMapping("/publications")
public class PublicationController {
	@Autowired
	IPublicationService publicationService;

	@PostMapping(value = "/add")
	public Publication addPublication(@RequestBody Publication publication) {
		return publicationService.add(publication);
	}
	
	@PutMapping(value = "/update/{id}")
	public Publication updatePublication(@RequestBody Publication publication) {
		return publicationService.update(publication);

	}

	@DeleteMapping(value = "delete/{id}")
	public void deletePublication(@PathVariable Long id) {
		publicationService.delete(id);

	}
	@GetMapping()
	public List<Publication> findAllEvents() {
		return publicationService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Publication findPublicationById(@PathVariable Long id) {

		return publicationService.getById(id);

	}
	
	@GetMapping(value = "find/{title}")
	public Publication findPublicationByTitle(@PathVariable String title) {

		return publicationService.getByTitle(title);

	}

	
}
