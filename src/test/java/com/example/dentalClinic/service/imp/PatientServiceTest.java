package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Address;
import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PatientServiceTest {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IPatientService interface of
    //service package
    @Autowired
    IPatientService patientService;

    @Test
        //I want to test the relationship between patient and address
    void createPatient() throws ResourceNotFoundException {
        //Set address
        Address address1 = new Address("Street1", 123, "location1", "province1");
        //Set patient
        Patient patient1 = new Patient("Paul", "Mendez", "34567890", LocalDate.of(2022, 7, 4), address1);

        patientService.createPatient(patient1);

        Patient patientFound = patientService.readPatient(patient1.getId());
        assertEquals(patientFound.getAddress().getId(), address1.getId());

    }

}