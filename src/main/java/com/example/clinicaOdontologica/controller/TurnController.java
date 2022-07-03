package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.model.Turn;
import com.example.clinicaOdontologica.model.dto.TurnDto;
import com.example.clinicaOdontologica.service.imp.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
    //ResponseEntity<?>: return a status. In this case status ok (201)
    public ResponseEntity<?> saveTurn(@RequestBody TurnDto turn) {
        Turn newTurn = turnService.createTurn(turn);
        return new ResponseEntity(newTurn, HttpStatus.CREATED);
    }


    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll() {
        Set<TurnDto> turns = turnService.bringAll();
        return ResponseEntity.ok(turns);

    }
}
