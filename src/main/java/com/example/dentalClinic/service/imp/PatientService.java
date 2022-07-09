package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.dto.PatientDto;
import com.example.dentalClinic.repository.IPatientRepository;
import com.example.dentalClinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//This annotation indicate that the class belongs to the service layer
@Service

//I indicate that the IPatientService interface methods will be implemented here
public class PatientService implements IPatientService {

    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IPatientRepository interface of
    //repository package
    @Autowired
    IPatientRepository patientRepository;

    //Allows me to convert from PatientDto
    @Autowired
    ObjectMapper mapper;


    //..................................OVERRIDE METHODS............................................
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    // .orElseThrow(()) I convert the exception to supplier(function) of type <T>. I pass
    // as parameter a portion of code to execute
    public Patient readPatient(Long id) throws ResourceNotFoundException {
        //Evaluate the condition that a patient is null
        return patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Don`t exist the patient with id " + id + " please enter a correct id"));

    }


    @Override
    public void modifyPatient(Patient patient) {
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        patientRepository.save(patient);

    }

    @Override
    // .orElseThrow(()) I convert the exception to supplier(function) of type <T>. I pass
    // as parameter a portion of code to execute
    public void deletePatient(Long id) throws ResourceNotFoundException {
        Patient patientFound = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the patient " +
                        "with id " + id + " please enter a correct id"));
        patientRepository.deleteById(patientFound.getId());
    }

    @Override
    public List<PatientDto> findAll() {
        List<PatientDto> patientDtos = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            patientDtos.add(mapper.convertValue(patient, PatientDto.class));
        }
        return patientDtos;
    }
}
