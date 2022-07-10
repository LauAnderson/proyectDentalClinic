package com.example.dentalClinic.service.imp;
import com.example.dentalClinic.exceptions.ResourceNotFoundException;
import com.example.dentalClinic.model.Appointment;
import com.example.dentalClinic.dto.AppointmentDto;
import com.example.dentalClinic.repository.IAppointmentRepository;
import com.example.dentalClinic.service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    IAppointmentRepository appointmentRepository;

    //Allows me to convert from TurnDto
    @Autowired
    ObjectMapper mapper;

    @Override
    public Appointment createTurn(AppointmentDto turn) {
        Appointment newAppointment = mapper.convertValue(turn, Appointment.class);
        return appointmentRepository.save(newAppointment);
    }

    @Override
    // .orElseThrow(()) I convert the exception to supplier(function) of type <T>. I pass
    // as parameter a portion of code to execute
    public Appointment readTurn(Long id) throws ResourceNotFoundException {
        //Evaluate the condition that a patient is null
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the appointment with id " + id + " please enter a correct id"));

    }

    @Override
    public void modifyTurn(Appointment appointmentNewValue, Long id) throws ResourceNotFoundException {
        Appointment appointmentToChange = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment with id " + id + " not found"));
        if (appointmentNewValue.getDateTime() != null) {
            appointmentToChange.setDateTime(appointmentNewValue.getDateTime());

            appointmentRepository.save(appointmentToChange);
        }
    }

    @Override
    public void deleteTurn(Long id) throws ResourceNotFoundException {
        Appointment appointmentFound = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don`t exist the appointment with id " + id + " please enter a correct id"));
        appointmentRepository.deleteById(appointmentFound.getId());
    }

    @Override
    public List<AppointmentDto> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        //.stream(): is used to process collections of objects
        //.map:  is a method in the Stream class that represents a functional programming concept. In simple words, the
        // map() is used to transform one object into other by applying a function
        return  appointments.stream()
                .map(appointment -> mapper.convertValue(appointment, AppointmentDto.class))
                .toList();
    }
}
