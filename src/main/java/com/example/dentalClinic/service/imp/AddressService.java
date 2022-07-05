package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.model.Address;
import com.example.dentalClinic.repository.IAddressRepository;
import com.example.dentalClinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This annotation indicate that the class belongs to the service layer
@Service

//I indicate that the IAddressService interface methods will be implemented here
public class AddressService implements IAddressService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IAddressRepository interface of
    //repository package
    @Autowired
    IAddressRepository addressRepository;

    //..................................OVERRIDE METHODS.........................................
    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);

    }

    @Override
    public void modifyAddress(Address address) {
        addressRepository.save(address);

    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);

    }

}
