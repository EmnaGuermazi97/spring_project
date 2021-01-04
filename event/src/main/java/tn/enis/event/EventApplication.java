package tn.enis.event;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tn.enis.event.entity.Event;
import tn.enis.event.repository.EventRepository;

@SpringBootApplication
@EnableDiscoveryClient

public class EventApplication implements CommandLineRunner {
	
	@Autowired
	EventRepository eventRepository;
	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
		
	}
	public void run(String... args) throws Exception {
        LocalDate date1 = LocalDate.parse("2018-01-07"); 
        LocalDate date2 = LocalDate.parse("2018-02-08"); 
        LocalDate date3 = LocalDate.parse("2018-03-09"); 
        LocalDate date4 = LocalDate.parse("2018-04-10"); 
        
		Event event1 = new Event("evenement1",date1,"Sfax");
		Event event2 = new Event("evenement2",date2,"Tunis");
		Event event3 = new Event("evenement3",date3,"Sousse");
		Event event4 = new Event("evenement4",date4,"Djerba");

		eventRepository.save(event1);	
		eventRepository.save(event2);	
		eventRepository.save(event3);	
		eventRepository.save(event4);	



		}


		 
	}

