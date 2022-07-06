package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.model.Address;
import com.example.dentalClinic.repository.IAddressRepository;
import com.example.dentalClinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the IDentistService interface methods will be implemented here
public class AddressService implements IAddressService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IDentistRepository interface of
    //repository package
    @Autowired
    IAddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address readAddress(Long id) {
        //Evaluate the condition that a dentist is null
        Address addressFound = addressRepository.findById(id).orElse(null);
        return addressFound;
    }

    @Override
    public void modifyAddress(Address address) {
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
