package com.example.clinicaOdontologica.service;



import com.example.clinicaOdontologica.model.Patient;

import java.util.List;

//In this class the cruds methods are established, they will be implemented in the service.imp package
public interface IPatientService {
    //....................................CRUD METHODS.........................................
    Patient save(Patient patient);

    List<Patient> findAll();

    Patient findById(Long id);

    void deleteById(Long id);

    void update(Patient patient);
}
