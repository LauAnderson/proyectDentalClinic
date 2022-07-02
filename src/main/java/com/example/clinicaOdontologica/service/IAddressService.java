package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Address;
import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.model.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IAddressService {

    //.......................................METHODS.........................................
    void createAddress(Address address);

    void modifyAddress(Address address);

    void deleteAddress(Long id);


}
