package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
//......................................TABLE IN DB...................................................
//With these annotations I create a table in the DB
@Entity
@Table

//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

public class Turn {
    //....................................ATTRIBUTES...................................................
    //These annotations are used to indicate that this is the id in the DB table
    //We make the configurations of its value
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dateTime;

    //....................................TABLE MAPPING IN DB............................................
    //These annotations are used to map the turn with the dentist
    //The ManyToOne relationship indicates that many turns have one dentist
    @ManyToOne
    private Dentist dentist;

    //The ManyToOne relationship indicates that many turns have one patient
    @ManyToOne
    private Patient patient;


    //..................................EMPTY BUILDER...................................................
    public Turn() {
    }

    //.................................BUILDER WITHOUT ID................................................
    public Turn(LocalDateTime dateTime, Dentist dentist) {
        this.dateTime = dateTime;
        this.dentist = dentist;
    }
}
