package com.example.dentalClinic.dto;
import com.example.dentalClinic.model.Dentist;
import com.example.dentalClinic.model.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDto {

    private Long id;
    private Patient patient;
    private Dentist dentist;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    public AppointmentDto() {
    }
}
