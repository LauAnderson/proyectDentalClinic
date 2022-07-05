package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.model.Address;
import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
class PatientServiceTest {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IPatientService interface of
    //service package
    @Autowired
    IPatientService patientService;

    @Test
    //I want to test the relationship between patient and address
    void createPatient() {
        //Set address
        Address address1 = new Address("Street1", 123, "location1",
                "province1");
        Address address2 = new Address("Street2", 345, "location2",
                "province2");
        //Set patient
        Patient patient1 = new Patient("Paul", "Mendez", "34567890",
                LocalDate.of(2022, 07, 04),address1 );
        Patient patient2 = new Patient("John", "Anderson", "26567591",
                LocalDate.of(2022, 07, 05),address2 );

        patientService.createPatient(patient1);
        patientService.createPatient(patient2);

    }
}