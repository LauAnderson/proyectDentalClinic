package com.example.dentalClinic;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentalClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalClinicApplication.class, args);

		//Indicate de log4j.properties
		PropertyConfigurator.configure("src/main/log4j.properties");
	}

}
