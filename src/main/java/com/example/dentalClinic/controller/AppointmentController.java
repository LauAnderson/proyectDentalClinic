package com.example.dentalClinic.controller;
import com.example.dentalClinic.dto.AppointmentDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.service.imp.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> saveTurn(@RequestBody AppointmentDto turn) {
        Appointment newAppointment = appointmentService.createTurn(turn);
        return new ResponseEntity(newAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTurn(@PathVariable Long id) throws ResourceNotFoundException {
        Appointment appointmentFound = appointmentService.readTurn(id);
        return ResponseEntity.ok(appointmentFound);
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        List<AppointmentDto> appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.deleteTurn(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTurn(@PathVariable Long id, @RequestBody Appointment appointment)
            throws ResourceNotFoundException {
        appointmentService.modifyTurn(appointment, id);
        return ResponseEntity.ok(null);
    }
}
