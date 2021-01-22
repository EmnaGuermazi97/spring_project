package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entity.Publication;

@Service
public class PublicationServiceImpl implements IPublicationService{

	@Autowired
	PublicationRepository publicationRepository;
	
	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication getById(Long id) {
		return publicationRepository.findById(id).get();

	}

	@Override
	public Publication add(Publication publication) {
		return publicationRepository.save(publication);

	}

	@Override
	public void delete(Long id) {
		publicationRepository.deleteById(id);
		
	}

	@Override
	public Publication update(Publication publication) {
		return publicationRepository.save(publication);

	}

	@Override
	public Publication getByTitle(String title) {
		return publicationRepository.findByTitre(title) ;
	}

}
