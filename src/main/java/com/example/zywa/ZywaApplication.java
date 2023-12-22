package com.example.zywa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.zywa.service.CardStatusService;

@SpringBootApplication
public class ZywaApplication {

	 public static void main(String[] args) {
	        SpringApplication.run(ZywaApplication.class, args);
	    }

	    @Bean
	    public CommandLineRunner dataLoader(CardStatusService cardStatusService) {
	        return args -> {
	            cardStatusService.importCSV("pickup.csv");
	            cardStatusService.importCSV("delivery_exceptions.csv");
	            cardStatusService.importCSV("delivered.csv");
	            cardStatusService.importCSV("returned.csv");
	        };
	    }
}
