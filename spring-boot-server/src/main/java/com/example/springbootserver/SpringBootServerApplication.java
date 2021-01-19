package com.example.springbootserver;

import com.example.springbootserver.models.ERole;
import com.example.springbootserver.models.Role;
import com.example.springbootserver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootServerApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		roleRepository.save(new Role(ERole.ROLE_USER));
//		roleRepository.save(new Role(ERole.ROLE_ADMIN));
//		roleRepository.save(new Role(ERole.ROLE_MODERATOR));
	}
}
