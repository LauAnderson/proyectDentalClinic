package com.example.clinicaOdontologica.dto;

import com.example.clinicaOdontologica.model.Dentist;
import com.example.clinicaOdontologica.model.Patient;
import lombok.Getter;
import lombok.Setter;

//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

//DTO are objects that carry data between processes in order to reduce the number of methods calls
//They are flat data structures that contain no business logic.

public class TurnDto {

    //....................................ATTRIBUTES...................................................
    private Patient paciente;
    private Dentist odontologo;

    //..................................EMPTY BUILDER...................................................
    public TurnDto() {
    }
}
