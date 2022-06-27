package com.example.clinicaOdontologica.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//......................................TABLE IN DB....................................................
//With these annotations I create a table in the DB
@Entity
@Table

//....................................GETTER AND SETTERS...............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

public class Address {

    //....................................ATTRIBUTES...................................................
    //These annotations are used to indicate that this is the id in the DB table
    //We make the configurations of its value
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String street;
    private Integer number;
    private String location;
    private String province;


    //....................................TABLE MAPPING IN DB............................................
    //We do not establish a relationship because we access to address from the patient



    //..................................EMPTY BUILDER...................................................
    public Address() {
    }

    //.................................BUILDER WITHOUT ID................................................
    public Address(String street, Integer number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }
}
