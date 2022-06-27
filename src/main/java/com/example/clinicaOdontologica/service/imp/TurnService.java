package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.dto.TurnDto;
import com.example.clinicaOdontologica.repository.ITurnRepository;
import com.example.clinicaOdontologica.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the ITurnService interface methods will be implemented here
public class TurnService implements ITurnService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of ITurnRepository interface of
    //repository package
    @Autowired
    ITurnRepository turnRepository;



    //..................................OVERRIDE METHODS.........................................
    @Override
    public void save(TurnDto turnDTO) {

    }

    @Override
    public List<TurnDto> findAll() {
        return null;
    }

    @Override
    public TurnDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(TurnDto turnDto) {

    }
}
