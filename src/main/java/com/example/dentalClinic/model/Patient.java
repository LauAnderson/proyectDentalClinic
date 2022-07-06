package com.example.dentalClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//......................................TABLE IN DB...................................................
//With this annotation it indicates that patient is an entity in the db and that it creates a table with that name
@Entity
@Table

//....................................GETTER AND SETTERS...............................................
//With this annotation generate automatically getters and setters
@Getter
@Setter

public class Patient {
    //....................................ATTRIBUTES...................................................
   //These annotations are used to indicate that this is the id in the DB table
   //We make the configurations of its value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate admissionDate;


    //....................................TABLE MAPPING IN DB............................................
    //These annotations are used to map the patient with the address
    //The OneToOne relationship indicates that one patient have one address
    @OneToOne (cascade = CascadeType.ALL)
    //With the JoinColumn annotation I indicate the mapping to the Address table through the id
    //This id in this table is a foreign key
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    //The OneToMany relationship indicates that one patient have many turns
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Turn> turnList = new HashSet<>();


    //..................................EMPTY BUILDER...................................................
    public Patient() {
    }

    //.................................BUILDER WITHOUT ID................................................
    public Patient(String name, String lastName, String dni, LocalDate admissionDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
    }
}
