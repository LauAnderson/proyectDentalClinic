package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.model.dto.TurnDto;
import com.example.clinicaOdontologica.service.imp.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Rest: restrictions
//Controller:This annotation allows you to receive http requests and respond to them
@RestController

//This annotation takes care of relating a method to http request. indicating that the path of the url is patients
@RequestMapping(path = "/turns")

public class TurnController {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of TurnService class of service.imp
    @Autowired
    private TurnService turnService;

    //................................HTTP REQUEST..................................................
    @PostMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> saveTurn(@RequestBody TurnDto turn) {
        turnService.createTurn(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll() {
        turnService.bringAll();
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
