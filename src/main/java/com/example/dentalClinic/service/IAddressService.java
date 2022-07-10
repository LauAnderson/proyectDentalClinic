package com.example.dentalClinic.service;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Address;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IAddressService {

    Address createAddress(Address address);

    Address readAddress(Long id) throws ResourceNotFoundException;

    void modifyAddress(Address addressNewValue, Long id) throws ResourceNotFoundException;

    void deleteAddress(Long id)throws ResourceNotFoundException;
}
