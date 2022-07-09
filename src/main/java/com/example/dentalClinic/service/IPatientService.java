package com.example.dentalClinic.service;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.dto.PatientDto;

import java.util.List;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IPatientService {
    //........................................METHODS........................................
    Patient createPatient(Patient patient);

    Patient readPatient(Long id) throws ResourceNotFoundException;

    void modifyPatient(Patient patient);

    void deletePatient(Long id) throws ResourceNotFoundException;

    List<PatientDto> bringAll();
}
