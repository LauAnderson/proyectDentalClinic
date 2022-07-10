package com.example.dentalClinic.controller;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Address;
import com.example.dentalClinic.service.imp.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<?> saveAddress(@RequestBody Address address) {
        Address newAddress = addressService.createAddress(address);
        return new ResponseEntity(newAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAddress(@PathVariable Long id) throws ResourceNotFoundException {
        Address addressFound = addressService.readAddress(id);
        return ResponseEntity.ok(addressFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) throws ResourceNotFoundException{
        if (addressService.readAddress(id).getId().equals(id))
            addressService.deleteAddress(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) throws ResourceNotFoundException{
        addressService.modifyAddress(address, id);
        return ResponseEntity.ok(null);
    }
}
