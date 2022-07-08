package com.example.dentalClinic.controller;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.model.dto.DentistDto;
import com.example.dentalClinic.service.imp.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Rest: restrictions
//Controller:This annotation allows you to receive http requests and respond to them
@RestController

//This annotation takes care of relating a method to http request. indicating that the path of the url is dentists
@RequestMapping(path = "/dentists")
public class DentistController {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of DentistService class of service.imp
    @Autowired
    private DentistService dentistService;

    //................................HTTP REQUEST..................................................
    @PostMapping
    //ResponseEntity<?>: return a status. In this case status created (201)
    public ResponseEntity<?> saveDentist(@RequestBody Dentist dentist) {
        Dentist newDentist = dentistService.createDentist(dentist);
        return new ResponseEntity(newDentist, HttpStatus.CREATED);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> findDentist(@PathVariable Long id) throws ResourceNotFoundException {
        Dentist dentistFound = dentistService.readDentist(id);
        return ResponseEntity.ok(dentistFound);
    }

    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll() {
        List<DentistDto> dentists = dentistService.bringAll();
        return ResponseEntity.ok(dentists);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status no content (204)
    public ResponseEntity<?> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        if (dentistService.readDentist(id).getId().equals(id))
            dentistService.deleteDentist(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updateDentist(@RequestBody Dentist dentist) {
        dentistService.modifyDentist(dentist);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
