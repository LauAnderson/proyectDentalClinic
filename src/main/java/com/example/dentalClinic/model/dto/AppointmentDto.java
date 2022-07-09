package com.example.dentalClinic.model.dto;

import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.model.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

//Tells to ignore properties that are not required
@JsonIgnoreProperties(ignoreUnknown = true)

//DTO are objects that carry data between processes in order to reduce the number of methods calls
//They are flat data structures that contain no business logic.
public class AppointmentDto {

    //....................................ATTRIBUTES...................................................
    private Long id;
    private Patient patient;
    private Dentist dentist;

    //With this annotation I convert from LocalDateTime to String
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    //..................................EMPTY BUILDER...................................................
    public AppointmentDto() {
    }
}
