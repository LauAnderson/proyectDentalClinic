package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IDentistService interface of
    //service package
    @Autowired
    IDentistService dentistService;

    @Test
    void createDentist() {
        Dentist dentist = new Dentist();
        dentist.setName("Marcos");
        dentist.setLastName("Perez");
        dentist.setTuition("MN 1234");

        dentistService.createDentist(dentist);
        assertTrue(dentistService.bringAll().size()>0);

    }
}