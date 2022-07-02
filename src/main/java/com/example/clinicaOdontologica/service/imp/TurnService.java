package com.example.clinicaOdontologica.service.imp;

import com.example.clinicaOdontologica.model.Turn;
import com.example.clinicaOdontologica.model.dto.TurnDto;
import com.example.clinicaOdontologica.repository.ITurnRepository;
import com.example.clinicaOdontologica.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//This annotation indicate that the class belongs to the service layer
@Service


//I indicate that the ITurnService interface methods will be implemented here
public class TurnService implements ITurnService {
    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of ITurnRepository interface of
    //repository package
    @Autowired
    ITurnRepository turnRepository;

    //Allows me to convert from TurnDto
    @Autowired
    ObjectMapper mapper;


    //..................................OVERRIDE METHODS.............................................
    @Override
    public void createTurn(TurnDto turn) {
        Turn newTurn = mapper.convertValue(turn, Turn.class);
        turnRepository.save(newTurn);
    }

    @Override
    public Set<TurnDto> bringAll() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnDto> turnDtos = new HashSet<TurnDto>();
        for(Turn turn : turns )
            turnDtos.add(mapper.convertValue(turn,TurnDto.class));

        return turnDtos;
    }
}
