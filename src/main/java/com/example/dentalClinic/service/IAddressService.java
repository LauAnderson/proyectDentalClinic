package com.example.dentalClinic.service;

import com.example.dentalClinic.model.Address;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IAddressService {

    //.......................................METHODS.........................................
    void createAddress(Address address);

    void modifyAddress(Address address);

    void deleteAddress(Long id);


}
