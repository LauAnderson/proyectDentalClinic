package com.example.clinicaOdontologica;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentalClinicApplication {

	//Indicate de log4j.properties
	PropertyConfigurator.configure("log4j.properties");

	public static void main(String[] args) {
		SpringApplication.run(DentalClinicApplication.class, args);
	}

}
