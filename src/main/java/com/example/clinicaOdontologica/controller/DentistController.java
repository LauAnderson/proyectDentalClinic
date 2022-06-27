package com.example.clinicaOdontologica.controller;


import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.service.imp.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //................................HTTP REQUEST.................................................
    @PostMapping
    //RequestBody: is the data that is sent in the body of the post request. Here we send a dentist object
    public void saveDentist(@RequestBody Dentist dentist){
        dentistService.save(dentist);
    }

    @GetMapping
    public List<Dentist> getAll() {
        return dentistService.findAll();
    }

    //indicate that to do this get method in the path I must pass the id number
    @GetMapping(path = "/{id}")
    //ResponseEntity:represents an HTTP response, including headers, body, and statuse.
    public ResponseEntity<Dentist> getById(@PathVariable Long id) {
        Dentist dentistResponse = dentistService.findById(id);
        //Indicate the status request is ok (200)
        return ResponseEntity.ok(dentistResponse);
    }

    //indicate that to do this delete method in the path I must pass the id number
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        dentistService.deleteById(id);
    }

    //indicate that to do this put method in the path I must pass the id number
    @PutMapping(path = "{id}")
    //RequestBody: is the data that is sent in the body of the post request. Here we send a dentist object
    public void putById(@PathVariable Long id, @RequestBody Dentist dentist) {
        dentist.setId(id);
        dentistService.update(dentist);
    }
}
