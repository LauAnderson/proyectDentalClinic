package com.example.dentalClinic.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//......................................TABLE IN DB....................................................
//With this annotation it indicates that address is an entity in the db and that it creates a table with that name
@Entity
@Table

//....................................GETTER AND SETTERS...............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

public class Address {

    //....................................ATTRIBUTES...................................................
    //These annotations are used to indicate that this is the id in the DB table
    //We make the configurations of its value: autogenerate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String street;
    private Integer number;
    private String location;
    private String province;


    //....................................TABLE MAPPING IN DB............................................
    //We do not establish a relationship because we access to address from the patient.
    //Because that reason I do not do an AddressService or AddressController or IAddressRepository



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
