package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.repository.IDentistRepository;
import com.example.dentalClinic.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the IDentistService interface methods will be implemented here
public class DentistService implements IDentistService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IDentistRepository interface of
    //repository package
    @Autowired
    IDentistRepository dentistRepository;

    //..................................OVERRIDE METHODS.........................................
    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist readDentist(Long id) {
        //Evaluate the condition that a dentist is null
        Dentist dentistFound = dentistRepository.findById(id).orElse(null);
        return dentistFound;
    }

    @Override
    public void modifyDentist(Dentist dentist) {
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);

    }

    @Override
    public List<Dentist> bringAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        return dentists;
    }
}
