package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Dentist;

import java.util.List;
import java.util.Optional;

//In this class the cruds methods are established, they will be implemented in the service.imp package
public interface IDentistService {
    //....................................CRUD METHODS.........................................


    // GUARDAR → devolvemos Odontologo para saber qué ID tiene asignado
    Dentist save(Dentist dentist);

    List<Dentist> findAll();

    Optional<Dentist> findById(Long id);

    void deleteById(Long id);

    void update(Dentist dentist);

}
