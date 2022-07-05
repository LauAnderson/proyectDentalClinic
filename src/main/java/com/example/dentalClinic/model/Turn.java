package com.example.dentalClinic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
//......................................TABLE IN DB...................................................
//With this annotation it indicates that turn is an entity in the db and that it creates a table with that name
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    //With this annotation I convert from LocalDateTime to String
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    //....................................TABLE MAPPING IN DB............................................
    //These annotations are used to map the turn with the dentist
    //The ManyToOne relationship indicates that many turns have one dentist
    //FetchType.EAGER: indicates that the relation must be loaded at the time the entity is loaded
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Dentist dentist;

    //The ManyToOne relationship indicates that many turns have one patient
    //FetchType.EAGER: indicates that the relation must be loaded at the time the entity is loaded
    //nullable = false: does not accept null values
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
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
