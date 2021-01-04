package tn.enis.tool;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tn.enis.tool.entity.Tool;
import tn.enis.tool.repository.ToolRepository;
@SpringBootApplication
@EnableDiscoveryClient
public class ToolApplication implements CommandLineRunner {
	@Autowired
	ToolRepository toolRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToolApplication.class, args);
	}
	public void run(String... args) throws Exception {
        LocalDate date1 = LocalDate.parse("2016-01-07"); 
        LocalDate date2 = LocalDate.parse("2017-02-08"); 
        LocalDate date3 = LocalDate.parse("2018-03-09"); 
        LocalDate date4 = LocalDate.parse("2019-04-10"); 
        
		Tool tool1 = new Tool(date1,"from_member1");
		Tool tool2 = new Tool(date2,"from_member2");
		Tool tool3 = new Tool(date3,"from_member1");
		Tool tool4 = new Tool(date4,"from_member2");

		toolRepository.save(tool1);	
		toolRepository.save(tool2);	
		toolRepository.save(tool3);	
		toolRepository.save(tool4);	



		}
}
