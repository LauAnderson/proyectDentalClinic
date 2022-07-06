package com.example.dentalClinic.controller;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Turn;
import com.example.dentalClinic.model.dto.TurnDto;
import com.example.dentalClinic.service.imp.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//Rest: restrictions
//Controller:This annotation allows you to receive http requests and respond to them
@RestController

//This annotation takes care of relating a method http request. indicating that the path of the url is patients
@RequestMapping(path = "/turns")

public class TurnController {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of TurnService class of service.imp
    @Autowired
    private TurnService turnService;

    //................................HTTP REQUEST..................................................
    @PostMapping
    //ResponseEntity<?>: return a status. In this case status created (201)
    public ResponseEntity<?> saveTurn(@RequestBody TurnDto turn) {
        Turn newTurn = turnService.createTurn(turn);
        return new ResponseEntity(newTurn, HttpStatus.CREATED);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?>  findTurn(@PathVariable Long id){
        Turn turnFound = turnService.readTurn(id);
        return ResponseEntity.ok(turnFound);
    }

    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll() {
        Set<TurnDto> turns = turnService.bringAll();
        return ResponseEntity.ok(turns);

    }
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status no content (204)
    public ResponseEntity<?> deleteTurn(@PathVariable Long id){
        if(turnService.readTurn(id).getId().equals(id))
            turnService.deleteTurn(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updateTurn(@RequestBody Turn turn) {
        turnService.modifyTurn(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
