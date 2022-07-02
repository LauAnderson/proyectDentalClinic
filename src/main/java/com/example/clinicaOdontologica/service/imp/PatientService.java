package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.repository.IPatientRepository;
import com.example.clinicaOdontologica.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

//This annotation indicate that the class belongs to the service layer
@Service

//I indicate that the IPatientService interface methods will be implemented here
public class PatientService implements IPatientService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IPatientRepository interface of
    //repository package
    @Autowired
    IPatientRepository patientRepository;

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
    public List<Patient> bringAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

}
