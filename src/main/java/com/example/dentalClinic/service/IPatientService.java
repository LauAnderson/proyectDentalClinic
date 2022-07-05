package com.example.dentalClinic.service;



import com.example.dentalClinic.model.Patient;

import java.util.List;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IPatientService {
    //........................................METHODS........................................
    Patient createPatient(Patient patient);
    Patient readPatient(Long id);
    void modifyPatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> bringAll();
}
