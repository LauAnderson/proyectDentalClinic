package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.model.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IDentistService {
    //........................................METHODS.........................................
    Dentist createDentist(Dentist dentist);
    Dentist readDentist(Long id);
    void modifyDentist(Dentist dentist);

    void deleteDentist(Long id);

    List<Dentist> bringAll();

}
