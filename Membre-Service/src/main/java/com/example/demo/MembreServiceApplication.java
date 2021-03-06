package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.Bean.EventBean;
import com.example.demo.Bean.PublicationBean;
import com.example.demo.Bean.ToolBean;
import com.example.demo.Bean.UserBean;
import com.example.demo.proxies.EventProxy;
import com.example.demo.proxies.Proxy;
import com.example.demo.proxies.PublicationProxy;
import com.example.demo.proxies.ToolProxy;
import com.example.demo.service.IMemberService;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHypermediaSupport(type = HypermediaType.HAL)//to resolve the pb that feign do not understand json created by data rest
public class MembreServiceApplication implements CommandLineRunner {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	IMemberService iMemberService;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	PublicationProxy publicationProxy;
	@Autowired
	EventProxy eventProxy;
	@Autowired
	ToolProxy toolProxy;
	@Autowired
	Proxy proxy;


	
	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}



	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd");
		/*
		// create 2 admins
		Date date0 = dateFormatter.parse("1997-12-06");
		Date date00 = dateFormatter.parse("1997-10-03");
		EnseignantChercheur admin1= new EnseignantChercheur("11094354", "Admin", "Guermazi", date0,"", "admin@hello.hello","","ENIS","Professeur");
		memberRepository.save(admin1);
		/*
		Membre admin2= new EnseignantChercheur("01752354", "Eya", "Ben Khater", date00,"","eyaBenkhater817@gmail.com","","ENIS", "MA");
	
		memberRepository.save(admin2);*/
		
		// créer deux instances de type membre un enseignant et une autre étudiant
		//sauvegrader les 2 dans la base de données
		
		EnseignantChercheur ens1= new EnseignantChercheur("11094354", "Guermazi", "Emna", new Date(), "", "emna.guermazi@enis.tn", "", "ENIS", "Professeur");
		memberRepository.save(ens1);
		Membre ens2= new EnseignantChercheur("98765432", "mariam", "lahami", new Date(), "",  "lahami@enis.tn", "2222", "ENIS", "MA");
	
		memberRepository.save(ens2);
		
		Date date1 = dateFormatter.parse("2010-05-01");
		Date date2 = dateFormatter.parse("2019-05-01");
		Date date3 = dateFormatter.parse("2012-05-01");
		Date date4 = dateFormatter.parse("2012-03-01");
		Etudiant etd1= new Etudiant("08170545", "ben fekih", "rim", date1, "",  "rim@enis.rn", "11111", date1, "test", "these",null);
		Etudiant etd2= new Etudiant("88570543", "ben ahmed", "sana", date2, "",  "sana@enis.rn", "11111", date2, "test", "mastere",null);
		Etudiant etd3= new Etudiant("08145423", "chaari", "rim", date3, "",  "chaari@enis.rn", "11111", date3, "test", "these", null);
		Etudiant etd4= new Etudiant("91081454", "ayadi", "ali", date4, "",  "ayadi@enis.rn", "11111", date4, "test", "mastre",null);
		memberRepository.save(etd1);
		memberRepository.save(etd2);
		memberRepository.save(etd3);
		memberRepository.save(etd4);
		
	//	Long idMember= getMemberId.getMemberIdByMemberCin("01752354");
		//System.out.println("this is the member id found by the cin: "+memberRepository.getMemberIdByMemberCin("11094354"));

		/*
		
		// affecter un étduiant à un enseigant
		iMemberService.affecterencadrantToetudiant(5L, 1L);
		iMemberService.affecterencadrantToetudiant(6L, 1L);
		iMemberService.affecterencadrantToetudiant(3L, 1L);
		
		// find etudiants encadré par 1
		
		List<Etudiant> etds=etudiantRepository.findByEncadrant(ens1);
		System.out.print(etds.size());
		*/
		//affecter une publication à un auteur
/*	
		//1-récupérer la publication par id en invoquant publication-service
		PublicationBean pub1=publicationProxy.recupererUnePublication(1L).getContent();
		System.out.println(pub1.getTitre()+ "  "+pub1.getId());
		PublicationBean pub2=publicationProxy.recupererUnePublication(2L).getContent();
		System.out.println(pub2.getTitre()+ "  "+pub2.getId());
		
		//2- affecter pub à member
		iMemberService.affecterauteurTopublication(1L,pub1.getId());
		iMemberService.affecterauteurTopublication(2L,pub1.getId());
		iMemberService.affecterauteurTopublication(1L,pub2.getId());
		
		//afficher le nombre de publication du membre 1
		List<PublicationBean> lstpubs=iMemberService.findPublicationparauteur(1L);
		lstpubs.forEach(r->System.out.println(r.toString()));

		PublicationBean p=publicationProxy.recupererUnePublication(1L).getContent();
		System.out.println(p);
		
	
		
		// to make sure communication is assured with Event Ms
		
		
		

		//récupérer les evenement par id en invoquant evenement-service
		EventBean event1 =eventProxy.findEventById(1L).getContent();
		System.out.println(event1.getTitle()+ event1.getDate()+ "  "+event1.getId());
		
		EventBean event2 =eventProxy.findEventById(2L).getContent();
		System.out.println(event2.getTitle()+ event2.getDate()+ "  "+event2.getId());
		EventBean event3 =eventProxy.findEventById(2L).getContent();
		System.out.println(event3.getTitle()+ event3.getDate()+ "  "+event3.getId());

		iMemberService.assignMemberToEvent(1L,1L);
		iMemberService.assignMemberToEvent(2L,2L);
		iMemberService.assignMemberToEvent(1L,3L);
		List<EventBean>eventsListByMember= iMemberService.findEventsByMemberId(1L);
		eventsListByMember.forEach(r->System.out.println(r.getId()+"  " +r.getTitle()));
		





		//récupérer l'outil par id en invoquant outil-service
		ToolBean tool1 =toolProxy.findToolById(1L).getContent();
		System.out.println(tool1.getSource()+ " "+ tool1.getDate()+ "  "+tool1.getId());
		
		ToolBean tool2 =toolProxy.findToolById(2L).getContent();
		ToolBean tool3 =toolProxy.findToolById(3L).getContent();
		iMemberService.assignMemberToTool(1l, 1L);
		iMemberService.assignMemberToTool(1l, 2L);
		iMemberService.assignMemberToTool(1l, 3L);
		
		iMemberService.assignMemberToTool(2l, 4L);
		iMemberService.assignMemberToTool(2l, 2L);
		


*/


		
		
	}

}
