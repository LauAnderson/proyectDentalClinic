package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.model.dto.PatientDto;
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
    public Patient readPatient(Long id) {
        //Evaluate the condition that a patient is null
        Patient patientFound = patientRepository.findById(id).orElse(null);
        return patientFound;
    }

    @Override
    public void modifyPatient(Patient patient) {
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        patientRepository.save(patient);

    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public List<PatientDto> bringAll() {
        List<PatientDto> patientDtos = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            patientDtos.add(mapper.convertValue(patient, PatientDto.class));
        }
        return patientDtos;
    }
}
