package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.dto.PatientDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Patient;
import com.example.dentalClinic.repository.IPatientRepository;
import com.example.dentalClinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {
    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient readPatient(Long id) throws ResourceNotFoundException {
        return patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Don`t exist the patient with id " + id + " please enter a correct id"));

    }

    @Override
    public void modifyPatient(Patient patientNewValue, Long id) throws ResourceNotFoundException {
        Patient patientToChange = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t find a patient with id " + id));
        if (patientNewValue.getName() != null) {
            patientToChange.setName(patientNewValue.getName());
        }
        if (patientNewValue.getLastName() != null) {
            patientToChange.setLastName(patientNewValue.getLastName());
        }
        if (patientNewValue.getDni() != null) {
            patientToChange.setDni(patientNewValue.getDni());
        }
        if (patientNewValue.getAdmissionDate() != null) {
            patientToChange.setAdmissionDate(patientNewValue.getAdmissionDate());
        }
        patientRepository.save(patientToChange);
    }

    @Override
    public void deletePatient(Long id) throws ResourceNotFoundException {
        Patient patientFound = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the patient " +
                        "with id " + id + " please enter a correct id"));
        patientRepository.deleteById(patientFound.getId());
    }

    @Override
    public List<PatientDto> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> mapper.convertValue(patient, PatientDto.class))
                .toList();
    }
}
