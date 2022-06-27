package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.TurnDto;

import java.util.List;

//In this class the cruds methods are established, they will be implemented in the service.imp package
public interface ITurnService {
    //....................................CRUD METHODS.........................................
    void save(TurnDto turnDTO);

    List<TurnDto> findAll();

    TurnDto findById(Long id);

    void deleteById(Long id);

    void update(TurnDto turnDto);

}
