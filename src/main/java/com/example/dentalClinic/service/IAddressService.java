package com.example.dentalClinic.service;

import com.example.dentalClinic.model.Address;


//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IAddressService {

    Address createAddress(Address address);

    Address readAddress(Long id);

    void modifyAddress(Address address);

    void deleteAddress(Long id);
}
