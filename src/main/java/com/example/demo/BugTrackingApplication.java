package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Issues;
import com.example.demo.repository.BugTrackingRepository;

@SpringBootApplication
public class BugTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackingApplication.class, args);
	}
	
	//Entering initial values using CommandLineRunner
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			private BugTrackingRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Issues(101,"Issue with imports","Unused Imports causing Errors","Trip-Data-Service","Low","Trivial","Rajesh"));
				repo.save(new Issues(102,"Issue with Post Method","Post Method not implemented properly","Blood-Donors-Service","Urgent","Major","Arjun"));
				repo.save(new Issues(103,"Connection Issue","Connection to DataBase Check","Cab-Driver-Rest-API","High","Critical","John snow"));
				repo.save(new Issues(104,"Exception not handled","Unhandled Exceptions, add appropriate code to handle it","InvocieService-JAX-RS","Medium","Medium","Robb Stark"));
				repo.save(new Issues(105,"Configuration Server Issue","Check if the configuration Server is running","Trip-Data-Service-Client","High","Critical","SUNDAR"));

				
			}
			
		};
	}
	
	
}
