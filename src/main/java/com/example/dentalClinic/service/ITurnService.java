package com.example.dentalClinic.service;


import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.model.dto.TurnDto;

import java.util.Set;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface ITurnService {
    //.......................................METHODS.........................................
    Appointment createTurn(TurnDto turn);

    Appointment readTurn (Long id);

    void modifyTurn(Appointment appointment);

    void deleteTurn(Long id);

    Set<TurnDto> bringAll();
}
