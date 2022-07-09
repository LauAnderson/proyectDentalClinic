package com.example.dentalClinic.service;


import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.dto.AppointmentDto;

import java.util.List;
import java.util.Set;

//In this class the crud methods are established, they will be implemented in the service.imp package
public interface IAppointmentService {
    //.......................................METHODS.........................................
    Appointment createTurn(AppointmentDto turn);

    Appointment readTurn (Long id) throws ResourceNotFoundException;

    void modifyTurn(Appointment appointment);

    void deleteTurn(Long id) throws ResourceNotFoundException;

    List<AppointmentDto> findAll();
}
