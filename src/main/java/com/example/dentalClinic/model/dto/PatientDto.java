
package com.example.dentalClinic.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter
@Setter

//Tells to ignore properties that are not required
@JsonIgnoreProperties(ignoreUnknown = true)

//DTO are objects that carry data between processes in order to reduce the number of methods calls
//They are flat data structures that contain no business logic
public class PatientDto {

    //....................................ATTRIBUTES...................................................
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate admissionDate;


    //..................................EMPTY BUILDER...................................................
    public PatientDto() {
    }

}
