package com.example.dentalClinic.controller;

import com.example.dentalClinic.model.Address;
import com.example.dentalClinic.service.imp.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Rest: restrictions
//Controller:This annotation allows you to receive http requests and respond to them
@RestController

//This annotation takes care of relating a method to http request. indicating that the path of the url is dentists
@RequestMapping(path = "/address")
public class AddressController {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of AddressService class of service.imp
    @Autowired
    private AddressService addressService;

    //................................HTTP REQUEST..................................................
    @PostMapping
    //ResponseEntity<?>: return a status. In this case status created (201)
    public ResponseEntity<?> saveDentist(@RequestBody Address address) {
        Address newAddress = addressService.createAddress(address);
        return new ResponseEntity(newAddress, HttpStatus.CREATED);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @GetMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> findDentist(@PathVariable Long id) {
        Address addressFound= addressService.readAddress(id);
        return ResponseEntity.ok(addressFound);
    }

    //Indicate that to do this get method in the path I must pass the id number
    @DeleteMapping("/{id}")
    //ResponseEntity<?>: return a status. In this case status no content (204)
    public ResponseEntity<?> deleteDentist(@PathVariable Long id) {
        if (addressService.readAddress(id).getId().equals(id))
            addressService.deleteAddress(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    //ResponseEntity<?>: return a status. In this case status ok (200)
    public ResponseEntity<?> updateDentist(@RequestBody Address address) {
        addressService.modifyAddress(address);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
