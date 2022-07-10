package com.example.dentalClinic.service.imp;
import com.example.dentalClinic.dto.DentistDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.repository.IDentistRepository;
import com.example.dentalClinic.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class DentistService implements IDentistService {
    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist readDentist(Long id) throws ResourceNotFoundException {
        return dentistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the dentist with id " + id + " please enter a correct id"));
    }

    @Override
    public void modifyDentist(Dentist dentistNewValue, Long id) throws ResourceNotFoundException {
        Dentist dentistToChange = dentistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentist with id " + id + " not found"));

        if (dentistNewValue.getName() != null) {
            dentistToChange.setName(dentistNewValue.getName());
        }
        if (dentistNewValue.getLastName() != null) {
            dentistToChange.setLastName(dentistNewValue.getLastName());
        }
        if (dentistNewValue.getTuition() != null) {
            dentistToChange.setTuition(dentistNewValue.getTuition());
        }
        dentistRepository.save(dentistToChange);
    }

    @Override
    public void deleteDentist(Long id) throws ResourceNotFoundException {
        Dentist dentistFound = dentistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the dentist with id " + id + " please enter a correct id"));
        dentistRepository.deleteById(dentistFound.getId());
    }

    @Override
    public List<DentistDto> findAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        return dentists.stream()
                .map(dentist -> mapper.convertValue(dentist, DentistDto.class))
                .toList();
    }
}
