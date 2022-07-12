package com.example.dentalClinic.controller;

import com.example.dentalClinic.dto.DentistDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.service.imp.DentistService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dentists")
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @Operation(summary = "Create a dentist")
    @PostMapping
    public ResponseEntity<?> saveDentist(@RequestBody Dentist dentist) {
        Dentist newDentist = dentistService.createDentist(dentist);
        return new ResponseEntity(newDentist, HttpStatus.CREATED);
    }

    @Operation(summary = "Find a dentist by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> findDentist(@PathVariable Long id) throws ResourceNotFoundException {
        Dentist dentistFound = dentistService.readDentist(id);
        return ResponseEntity.ok(dentistFound);
    }

    @Operation(summary = "List all dentists")
    @GetMapping
    public ResponseEntity<?> listAll() {
        List<DentistDto> dentists = dentistService.findAll();
        return ResponseEntity.ok(dentists);
    }

    @Operation(summary = "Delete a dentist by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        dentistService.deleteDentist(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update a dentist by id")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDentist(@PathVariable Long id, @RequestBody Dentist dentist)
            throws ResourceNotFoundException {
        dentistService.modifyDentist(dentist, id);
        return ResponseEntity.ok(null);
    }
}
