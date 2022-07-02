package com.example.clinicaOdontologica.service;



import com.example.clinicaOdontologica.model.Patient;

import java.util.Collection;
import java.util.List;
import java.util.Set;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IPatientService {
    //........................................METHODS........................................
    Patient createPatient(Patient patient);
    Patient readPatient(Long id);
    void modifyPatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> bringAll();
}
