package com.example.clinicaOdontologica.controller;


import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.service.imp.DentistService;
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
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> saveDentist(@RequestBody Dentist dentist){
        dentistService.createDentist(dentist);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?>  findDentist(@PathVariable Long id){
        dentistService.readDentist(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll(){
        dentistService.bringAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> deleteDentist(@PathVariable Long id){
        if(dentistService.readDentist(id).equals(id))
            dentistService.deleteDentist(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updateDentist(@RequestBody Dentist dentist){
        dentistService.modifyDentist(dentist);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
