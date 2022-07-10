package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Address;
import com.example.dentalClinic.repository.IAddressRepository;
import com.example.dentalClinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This annotation indicate that the class belongs to the service layer
@Service
//I indicate that the IDentistService interface methods will be implemented here
public class AddressService implements IAddressService {
    @Autowired
    IAddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address readAddress(Long id) throws ResourceNotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Don`t found an address with the id " + id + " please enter a correct id"));
    }

    @Override
    public void modifyAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) throws ResourceNotFoundException{
        Address addressFound = addressRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Don`t found an address with the id " + id + " please enter a correct id"));
        addressRepository.deleteById(addressFound.getId());
    }
}
