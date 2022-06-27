package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.repository.IPatientRepository;
import com.example.clinicaOdontologica.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the IPatientService interface methods will be implemented here
public class PatientService implements IPatientService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IPatientRepository interface of
    //repository package
    @Autowired
    IPatientRepository patientRepository;

    //..................................OVERRIDE METHODS.........................................
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    //ESTE PREGUNTAR
    @Override
    public Patient findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public void update(Patient patient) {
        //This method belongs to the JpaRepository interface and allows us to perform an update
        patientRepository.saveAndFlush(patient);
    }
}
