package com.example.dentalClinic.service.imp;

import com.example.dentalClinic.model.Turn;
import com.example.dentalClinic.model.dto.TurnDto;
import com.example.dentalClinic.repository.ITurnRepository;
import com.example.dentalClinic.service.ITurnService;
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
    public Turn createTurn(TurnDto turn) {
        Turn newTurn = mapper.convertValue(turn, Turn.class);
        return turnRepository.save(newTurn);
    }

    @Override
    public Turn readTurn(Long id){
        //Evaluate the condition that a patient is null
        Turn turnFound = turnRepository.findById(id).orElse(null);
        return turnFound;

    }

    @Override
    public void modifyTurn(Turn turn){
        //ORM identifies whether the save call refers to a modification or the creation of a new record
        turnRepository.save(turn);
    }

    @Override
    public void deleteTurn(Long id) {
        turnRepository.deleteById(id);

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
