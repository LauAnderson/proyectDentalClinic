package com.example.dentalClinic.controller;
import com.example.dentalClinic.dto.DentistDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.service.imp.DentistService;
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

    @PostMapping
    public ResponseEntity<?> saveDentist(@RequestBody Dentist dentist) {
        Dentist newDentist = dentistService.createDentist(dentist);
        return new ResponseEntity(newDentist, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDentist(@PathVariable Long id) throws ResourceNotFoundException {
        Dentist dentistFound = dentistService.readDentist(id);
        return ResponseEntity.ok(dentistFound);
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        List<DentistDto> dentists = dentistService.findAll();
        return ResponseEntity.ok(dentists);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        dentistService.deleteDentist(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDentist(@PathVariable Long id, @RequestBody Dentist dentist)
            throws ResourceNotFoundException {
        dentistService.modifyDentist(dentist, id);
        return ResponseEntity.ok(null);
    }
}
