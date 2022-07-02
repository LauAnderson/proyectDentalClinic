package com.example.clinicaOdontologica;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentalClinicApplication {

	public static void main(String[] args) {

		//Indicate de log4j.properties
		PropertyConfigurator.configure("log4j.properties");

		SpringApplication.run(DentalClinicApplication.class, args);

	}

}
