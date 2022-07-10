package com.example.dentalClinic.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDto {

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate admissionDate;


    public PatientDto() {
    }

}
