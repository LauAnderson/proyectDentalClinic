package com.example.dentalClinic.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //With this annotation I convert from LocalDateTime to String
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;


    //FetchType.EAGER: indicates that the relation must be loaded at the time the entity is loaded
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
    private Patient patient;


    public Appointment() {
    }

    public Appointment(LocalDateTime dateTime, Dentist dentist) {
        this.dateTime = dateTime;
        this.dentist = dentist;
    }
}
