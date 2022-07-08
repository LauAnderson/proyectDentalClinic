package com.example.dentalClinic.controller;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.model.dto.PatientDto;
import com.example.dentalClinic.service.imp.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    //................................HTTP REQUEST..................................................

    @PostMapping
    //ResponseEntity<?>: return a status. In this case status created (201)
    public ResponseEntity<?> savePatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.createPatient(patient);
        return new ResponseEntity(newPatient, HttpStatus.CREATED);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: if patientId exists return a status. In this case status ok (200)
    //Else return status not found (400)
    public ResponseEntity<?> findPatient(@PathVariable Long id) throws ResourceNotFoundException {
        Patient patientFound = patientService.readPatient(id);
        return ResponseEntity.ok(patientFound);

    }

    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll() {
        List<PatientDto> patients = patientService.bringAll();
        return ResponseEntity.ok(patients);
    }


    //Indicate that to do this get method in the path I must pass the id number
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status no content (204)
    public ResponseEntity<?> deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
        if (patientService.readPatient(id).getId().equals(id))
            patientService.deletePatient(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient) {
        patientService.modifyPatient(patient);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
