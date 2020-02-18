package com.luv2code;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.luv2code.dao.AvocatRepository;
import com.luv2code.entities.Avocat;
import com.luv2code.entities.Role;
import com.luv2code.entities.User;
import com.luv2code.service.IUserService;

@SpringBootApplication
public class AvocatGestionWithoutSecurityApplication implements CommandLineRunner {

	@Autowired 
	AvocatRepository avocatRepository;
	
	@Autowired
	IUserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AvocatGestionWithoutSecurityApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	public void run(String... args) throws Exception {

		/*
		userService.cleanDataBase();
		userService.save(new Role("ADMIN"));
		userService.save(new Role("SECRETAIRE"));
		userService.save(new Role("AVOCAT"));

		Role roleAvocat= userService.getRoleByName("AVOCAT");
		Role roleAdmin = userService.getRoleByName("ADMIN");
		Role roleSecretaire = userService.getRoleByName("SECRETAIRE");
		
		User admin = new User("admin1", "admin1", Arrays.asList(roleAdmin));
		User Secretaire = new User("secretaire1", "secretaire1", Arrays.asList(roleSecretaire));
		User Avocat = new User("avocat1", "avocat1", Arrays.asList(roleAvocat));


		userService.save(admin);
		userService.save(Secretaire);
		userService.save(Avocat);
		*/
		
	}
		
}
