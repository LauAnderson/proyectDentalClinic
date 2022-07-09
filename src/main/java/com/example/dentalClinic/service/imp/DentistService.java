package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.dto.DentistDto;
import com.example.dentalClinic.repository.IDentistRepository;
import com.example.dentalClinic.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the IDentistService interface methods will be implemented here
public class DentistService implements IDentistService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IDentistRepository interface of
    //repository package
    @Autowired
    IDentistRepository dentistRepository;

    //Allows me to convert from DentistDto
    @Autowired
    ObjectMapper mapper;

    //..................................OVERRIDE METHODS.........................................
    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    // .orElseThrow(()) I convert the exception to supplier(function) of type <T>. I pass
    // as parameter a portion of code to execute
    public Dentist readDentist(Long id) throws ResourceNotFoundException {
        //Evaluate the condition that a dentist is null
        return dentistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the dentist with id " + id + " please enter a correct id"));

    }

    @Override
    public void modifyDentist(Dentist dentist) {
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        dentistRepository.save(dentist);
    }

    @Override
    // .orElseThrow(()) I convert the exception to supplier(function) of type <T>. I pass
    // as parameter a portion of code to execute
    public void deleteDentist(Long id) throws ResourceNotFoundException {
        Dentist dentistFound = dentistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the dentist with id " + id + " please enter a correct id"));
        dentistRepository.deleteById(dentistFound.getId());

    }

    @Override
    public List<DentistDto> bringAll() {
        List<DentistDto> dentistDtos = new ArrayList<>();
        List<Dentist> dentists = dentistRepository.findAll();
        for (Dentist dentist : dentists) {
            dentistDtos.add(mapper.convertValue(dentist, DentistDto.class));
        }
        return dentistDtos;
    }
}
