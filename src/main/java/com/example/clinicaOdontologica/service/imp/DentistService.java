package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.repository.IDentistRepository;
import com.example.clinicaOdontologica.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    //PREGUNTAR
    @Override
    public Optional<Dentist> findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public void update(Dentist dentist) {
        //This method belongs to the JpaRepository interface and allows us to perform an update
        dentistRepository.saveAndFlush(dentist);
    }
}
