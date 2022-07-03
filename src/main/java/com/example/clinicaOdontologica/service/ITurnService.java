package com.example.clinicaOdontologica.service;


import com.example.clinicaOdontologica.model.Turn;
import com.example.clinicaOdontologica.model.dto.TurnDto;

import java.util.Set;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface ITurnService {
    //.......................................METHODS.........................................
    Turn createTurn(TurnDto turn);

    Set<TurnDto> bringAll();
}
