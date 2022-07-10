package com.example.dentalClinic.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDto {

    private Long id;
    private String name;
    private String lastName;
    private String tuition;

    public DentistDto() {
    }
}
