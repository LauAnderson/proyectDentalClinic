package com.example.dentalClinic.service;

import com.example.dentalClinic.model.Dentist;

import java.util.List;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IDentistService {
    //........................................METHODS.........................................

    Dentist createDentist(Dentist dentist);

    Dentist readDentist(Long id);

    void modifyDentist(Dentist dentist);

    void deleteDentist(Long id);

    List<Dentist> bringAll();


}