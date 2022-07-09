package com.example.dentalClinic.service.imp;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.dto.AppointmentDto;
import com.example.dentalClinic.repository.IAppointmentRepository;
import com.example.dentalClinic.service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the ITurnService interface methods will be implemented here
public class AppointmentService implements IAppointmentService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of ITurnRepository interface of
    //repository package
    @Autowired
    IAppointmentRepository appointmentRepository;

    //Allows me to convert from TurnDto
    @Autowired
    ObjectMapper mapper;


    //..................................OVERRIDE METHODS.............................................
    @Override
    public Appointment createTurn(AppointmentDto turn) {
        Appointment newAppointment = mapper.convertValue(turn, Appointment.class);
        return appointmentRepository.save(newAppointment);
    }

    @Override
    // .orElseThrow(()) I convert the exception to supplier(function) of type <T>. I pass
    // as parameter a portion of code to execute
    public Appointment readTurn(Long id) throws ResourceNotFoundException {
        //Evaluate the condition that a patient is null
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the appointment with id " + id + " please enter a correct id"));

    }

    @Override
    public void modifyTurn(Appointment appointment) {
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteTurn(Long id) throws ResourceNotFoundException {
        Appointment appointmentFound = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the appointment with id " + id + " please enter a correct id"));
        appointmentRepository.deleteById(appointmentFound.getId());
    }

    @Override
    public Set<AppointmentDto> bringAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDto> appointmentDtos = new HashSet<AppointmentDto>();
        for (Appointment appointment : appointments)
            appointmentDtos.add(mapper.convertValue(appointment, AppointmentDto.class));

        return appointmentDtos;
    }
}
