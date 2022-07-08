package com.example.dentalClinic.service.imp;


import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.model.dto.TurnDto;
import com.example.dentalClinic.repository.ITurnRepository;
import com.example.dentalClinic.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the ITurnService interface methods will be implemented here
public class TurnService implements ITurnService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of ITurnRepository interface of
    //repository package
    @Autowired
    ITurnRepository turnRepository;

    //Allows me to convert from TurnDto
    @Autowired
    ObjectMapper mapper;


    //..................................OVERRIDE METHODS.............................................
    @Override
    public Appointment createTurn(TurnDto turn) {
        Appointment newAppointment = mapper.convertValue(turn, Appointment.class);
        return turnRepository.save(newAppointment);
    }

    @Override
    public Appointment readTurn(Long id)  {
        //Evaluate the condition that a patient is null
        Appointment appointmentFound = turnRepository.findById(id).orElse(null);
            return appointmentFound;

    }

    @Override
    public void modifyTurn(Appointment appointment){
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        turnRepository.save(appointment);
    }

    @Override
    public void deleteTurn(Long id){
        turnRepository.deleteById(id);
    }

    @Override
    public Set<TurnDto> bringAll() {
        List<Appointment> appointments = turnRepository.findAll();
        Set<TurnDto> turnDtos = new HashSet<TurnDto>();
        for(Appointment appointment : appointments)
            turnDtos.add(mapper.convertValue(appointment,TurnDto.class));

        return turnDtos;
    }
}
