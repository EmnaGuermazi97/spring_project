package com.example.demo.controller;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.EventBean;
import com.example.demo.Bean.PublicationBean;
import com.example.demo.Bean.ToolBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.PublicationProxy;
import com.example.demo.service.IMemberService;



@RestController
public class MembreRestController {
	@Autowired
	IMemberService iMemberService;
	@Autowired
	PublicationProxy publicationproxy;
	
	@GetMapping(value = "/membres")
	public List<Membre> findAllmembres()
	{
		return iMemberService.findAll();
	}

	@GetMapping(value = "/membres/{id}")
	public Membre findoneMembre(@PathVariable Long id)
	{
		return iMemberService.findMember(id);
	}
	
	@PostMapping(value = "/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant etd)
	{
		return iMemberService.addMember(etd);
	}

	@PostMapping(value = "/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur ens)
	{
		return iMemberService.addMember(ens);
	}
	@PostMapping(value = "/membres/add")
	public Membre addMembre(@RequestBody Membre member)
	{
		return iMemberService.addMember(member);
	}
	@PutMapping(value="/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p)
	{
		p.setId(id);
		return iMemberService.updateMember(p);
	}

	@PutMapping(value="/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)
	{
		p.setId(id);
	       return iMemberService.updateMember(p);
	}
	/*@DeleteMapping(value="/membres/{id}")
	public void deleteMembre(@PathVariable Long id)
	{
		return iMemberService.deleteMember(id);
	}*/
	@PutMapping(value="/membres/etudiant")
	public Membre affecter(@RequestParam Long idetd , @RequestParam Long idens )
	{
		
	       return iMemberService.affecterencadrantToetudiant(idetd, idens);
	}
	@GetMapping("/publications")
	public CollectionModel<PublicationBean>listerpublication()
	{
		return publicationproxy.listeDesPublications();
		
	}
	@GetMapping("/publications/{id}")
	public EntityModel<PublicationBean> listerunepublication(@PathVariable Long id)
	{
		return publicationproxy.recupererUnePublication(id);
		
	}
	@GetMapping("/publications/member/{id}")
	public List<PublicationBean>getPublicationsByMemberId(@PathVariable(name="id") Long idaut)
	{
		return iMemberService.findPublicationparauteur(idaut);		
	}
	@GetMapping("/events/member/{id}")
	public List<EventBean>getEventsByMemberId(@PathVariable(name="id") Long idMember)
	{
		return iMemberService.findEventsByMemberId(idMember);		
	}
	@GetMapping("/tools/member/{id}")
	public List<ToolBean>getToolsByMemberId(@PathVariable(name="id") Long idMember)
	{
		return iMemberService.findToolsByMemberId(idMember);		
	}
	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name="id") Long id)
	{
		Membre member=iMemberService.findMember(id);
		member.setPubs(iMemberService.findPublicationparauteur(id));
		
		return member;		
	}

	
}
