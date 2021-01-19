package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.example.demo.controllers.AuthController;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.ERole;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.payload.request.SignupRequest;

import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProxyserviceApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthController authController;
	@Autowired
	PasswordEncoder encoder;


	public static void main(String[] args) {
		SpringApplication.run(ProxyserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new Role(ERole.ROLE_USER));
		roleRepository.save(new Role(ERole.ROLE_ADMIN));
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(ERole.ROLE_ADMIN));
		User admin1 = new User("emna", "emna@gmail.com",encoder.encode("adminemna"));
		admin1.setRoles(roles);
		userRepository.save(admin1);	
		//admin2
		User admin2 = new User("eya", "eya@gmail.com",encoder.encode("admineya"));
		admin2.setRoles(roles);
		userRepository.save(admin2);
		
		//save admin1 
/*		SignupRequest signupRequest1 = new SignupRequest("EMNA","emnaguermazi817@gmail.com","adminemna");
        Set<String> rolesSet1 = new HashSet<>();
        rolesSet1.add("ROLE_ADMIN");
		signupRequest1.setRole(rolesSet1);
		authController.registerUser(signupRequest1);
		//save admin2
		SignupRequest signupRequest2 = new SignupRequest("EYA","eyabenKhater817@gmail.com","admineya");
        Set<String> rolesSet2 = new HashSet<>();
        rolesSet2.add("ROLE_ADMIN");
		signupRequest2.setRole(rolesSet2);
		authController.registerUser(signupRequest2);
		userRepository.findAll();*/
		
		
	}

}
