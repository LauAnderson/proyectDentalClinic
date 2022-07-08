package com.example.dentalClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//......................................TABLE IN DB...................................................
//With this annotation it indicates that dentist is an entity in the db and that it creates a table with that name
@Entity
@Table

//....................................GETTER AND SETTERS...............................................
//With this annotation generate automatically getters and setters
@Getter
@Setter
public class Dentist {

    //....................................ATTRIBUTES...................................................
    //These annotations are used to indicate that this is the id in the DB table
    //We make the configurations of its value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String tuition;

    //....................................TABLE MAPPING IN DB............................................
    //These annotations are used to map the dentist with the turn
    //The OneToMany relationship indicates that one dentist have many turns
    //FetchType.LAZY: the object is initialized only when required
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();


    //..................................EMPTY BUILDER...................................................
    public Dentist() {
    }

    //.................................BUILDER WITHOUT ID................................................
    public Dentist(String name, String lastName, String tuition) {
        this.name = name;
        this.lastName = lastName;
        this.tuition = tuition;
    }
}
