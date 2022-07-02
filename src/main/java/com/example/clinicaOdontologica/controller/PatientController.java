package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.service.imp.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> savePatient(@RequestBody Patient patient){
        patientService.createPatient(patient);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?>  findPatient(@PathVariable Long id){
        patientService.readPatient(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll(){
        patientService.bringAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }


    //Indicate that to do this get method in the path I must pass the id number
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        if(patientService.readPatient(id).equals(id))
            patientService.deletePatient(id);
            return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
        patientService.modifyPatient(patient);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
