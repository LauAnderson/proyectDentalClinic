package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.service.imp.DentistService;
import com.example.clinicaOdontologica.service.imp.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest: restrictions
//Controller:This annotation allows you to receive http requests and respond to them
@RestController

//This annotation takes care of relating a method to http request. indicating that the path of the url is patients
@RequestMapping(path = "/patients")
public class PatientController {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of PatientService class of service.imp
    @Autowired
    private PatientService patientService;

    //................................HTTP REQUEST.................................................

}
