package com.prog;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prog.entity.Role;
import com.prog.entity.User;
import com.prog.entity.UserRole;
import com.prog.service.UserService;

@SpringBootApplication
public class ProgserverApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProgserverApplication.class, args);
		System.out.println("Working Fine...");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting Code");
		
		  //Adding Admin Cred to Database 
			/*
			 * User user1 = new User();
			 * 
			 * //Adding Admin u user1.setUserName("NishadAdmin");
			 * user1.setFirstName("Nishad"); user1.setLastName("Kathane");
			 * user1.setPhone("7720912667");
			 * user1.setPassword(this.bCryptPasswordEncoder.encode("Nishad123"));
			 * user1.setEmail("Nishad@gmail.com");
			 * 
			 * Role role1 = new Role(); role1.setRoleName("Admin"); role1.setRoleId(52L);
			 * 
			 * Set<UserRole> userRoleSet = new HashSet<>(); UserRole userRole = new
			 * UserRole();
			 * 
			 * userRole.setUser(user1); userRole.setRole(role1);
			 * 
			 * userRoleSet.add(userRole);
			 * 
			 * User user = this.userService.createUser(user1, userRoleSet);
			 * System.out.println(user.toString());
			 */
		 
		

		
	}
	

}
