package com.example.dentalClinic.service;
import com.example.dentalClinic.dto.DentistDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Dentist;
import java.util.List;

public interface IDentistService {

    Dentist createDentist(Dentist dentist);

    Dentist readDentist(Long id) throws ResourceNotFoundException;

    void modifyDentist(Dentist dentistNewValue, Long id) throws ResourceNotFoundException;

    void deleteDentist(Long id) throws ResourceNotFoundException;

    List<DentistDto> findAll();


}
