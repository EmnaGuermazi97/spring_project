 package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.example.demo.dao.RoleRepository;
import com.example.demo.entities.ERole;
import com.example.demo.entities.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProxyserviceApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
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
		User admin = new User("admin","11094354", "admin@hello.hello", encoder.encode("adminadmin"));
		admin.setRoles(roles);
		userRepository.save(admin);
	}

}
