package com.example.dentalClinic.service;
import com.example.dentalClinic.dto.AppointmentDto;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Appointment;
import java.util.List;

public interface IAppointmentService {
    Appointment createTurn(AppointmentDto turn);

    Appointment readTurn(Long id) throws ResourceNotFoundException;

    void modifyTurn(Appointment appointmentNewValue, Long id) throws ResourceNotFoundException;

    void deleteTurn(Long id) throws ResourceNotFoundException;

    List<AppointmentDto> findAll();
}
