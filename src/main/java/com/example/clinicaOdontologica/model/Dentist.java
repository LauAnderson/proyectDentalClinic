package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//......................................TABLE IN DB...................................................
//With these annotations I create a table in the DB
@Entity
@Table

//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

public class Dentist {

    //....................................ATTRIBUTES...................................................
    //These annotations are used to indicate that this is the id in the DB table
    //We make the configurations of its value
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    private String registry;

    //....................................TABLE MAPPING IN DB............................................
    //These annotations are used to map the dentist with the turn
    //The OneToMany relationship indicates that one dentist have many turns
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "turns_id", referencedColumnName = "id")
    private Turn turn;
    //DEBERÍA SETEAR LOS TURNOS EN UN LISTADO?
    //Y CÓMO ESCRIBO ESTO EN TURNOS??


    //..................................EMPTY BUILDER...................................................
    public Dentist() {
    }

    //.................................BUILDER WITHOUT ID................................................
    public Dentist(String name, String lastName, String registry) {
        this.name = name;
        this.lastName = lastName;
        this.registry = registry;
    }
}
