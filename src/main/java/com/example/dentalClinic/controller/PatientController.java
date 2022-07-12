package com.example.dentalClinic.controller;

import com.example.dentalClinic.dto.PatientDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.service.imp.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Operation(summary = "Create a patient")
    @PostMapping
    public ResponseEntity<?> savePatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.createPatient(patient);
        return new ResponseEntity(newPatient, HttpStatus.CREATED);
    }

    @Operation(summary = "Find a patient by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> findPatient(@PathVariable Long id) throws ResourceNotFoundException {
        Patient patientFound = patientService.readPatient(id);
        return ResponseEntity.ok(patientFound);
    }

    @Operation(summary = "List all patients")
    @GetMapping
    public ResponseEntity<?> listAll() {
        List<PatientDto> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @Operation(summary = "Delete a patient")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
        patientService.deletePatient(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update a patient by id")
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patient) throws ResourceNotFoundException {
        patientService.modifyPatient(patient, id);
        return ResponseEntity.ok(null);
    }

}
