package com.example.dentalClinic.controller;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.dto.AppointmentDto;
import com.example.dentalClinic.service.imp.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//Rest: restrictions
//Controller:This annotation allows you to receive http requests and respond to them
@RestController

//This annotation takes care of relating a method http request. indicating that the path of the url is patients
@RequestMapping(path = "/appointments")

public class AppointmentController {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of TurnService class of service.imp
    @Autowired
    private AppointmentService appointmentService;

    //................................HTTP REQUEST..................................................
    @PostMapping
    //ResponseEntity<?>: return a status. In this case status created (201)
    public ResponseEntity<?> saveTurn(@RequestBody AppointmentDto turn) {
        Appointment newAppointment = appointmentService.createTurn(turn);
        return new ResponseEntity(newAppointment, HttpStatus.CREATED);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?>  findTurn(@PathVariable Long id) throws ResourceNotFoundException {
        Appointment appointmentFound = appointmentService.readTurn(id);
        return ResponseEntity.ok(appointmentFound);
    }

    @GetMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> listAll() {
        Set<AppointmentDto> turns = appointmentService.bringAll();
        return ResponseEntity.ok(turns);

    }
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status no content (204)
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) throws ResourceNotFoundException {
        if(appointmentService.readTurn(id).getId().equals(id))
            appointmentService.deleteTurn(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updateTurn(@RequestBody Appointment appointment) {
        appointmentService.modifyTurn(appointment);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
