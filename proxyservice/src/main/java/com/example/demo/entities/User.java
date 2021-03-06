package com.example.demo.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity
public class User {
	   @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @Size(max = 20)
       private String username;

       @Size(max = 50)
       private String email;

       @Size(max = 120)
       private String password;

       @ManyToMany(fetch = FetchType.LAZY)
       private Set<Role> roles = new HashSet<>();

       public User() {
       }

       public User(String username, String email, String password) {
           this.username = username;
           this.email = email;
           this.password = password;
       }
       

       public User(@Size(max = 50) String email, @Size(max = 120) String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(Long id, @Size(max = 20) String username, @Size(max = 50) String email,
			@Size(max = 120) String password, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public String getUsername() {
           return username;
       }

       public void setUsername(String username) {
           this.username = username;
       }

       public String getEmail() {
           return email;
       }

       public void setEmail(String email) {
           this.email = email;
       }

       public String getPassword() {
           return password;
       }

       public void setPassword(String password) {
           this.password = password;
       }

       public Set<Role> getRoles() {
           return roles;
       }

       public void setRoles(Set<Role> roles) {
           this.roles = roles;
       }
}
