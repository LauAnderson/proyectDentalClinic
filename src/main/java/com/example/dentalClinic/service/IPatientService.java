package com.example.dentalClinic.service;
import com.example.dentalClinic.dto.PatientDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Patient;
import java.util.List;

public interface IPatientService {
    Patient createPatient(Patient patient);

    Patient readPatient(Long id) throws ResourceNotFoundException;

    void modifyPatient(Patient patient);

    void deletePatient(Long id) throws ResourceNotFoundException;

    List<PatientDto> findAll();
}
