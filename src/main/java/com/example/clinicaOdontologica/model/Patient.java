package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

//......................................TABLE IN DB...................................................
//With these annotations I create a table in the DB
@Entity
@Table

//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter @Setter

public class Patient {
    //....................................ATTRIBUTES...................................................
   //These annotations are used to indicate that this is the id in the DB table
   //We make the configurations of its value
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private Address domicilio;

    //The OneToMany relationship indicates that one patient have many turns
    @OneToMany (cascade = CascadeType.ALL)
    //With the JoinColumn annotation I indicate the mapping to the Turn table through the id
    //This id in this table is a foreign key
    @JoinColumn(name = "turns_id", referencedColumnName = "id")
    private Turn turno;
    //DEBERIA SETEAR LOS TURNOS EN UN LISTADO??
    //Y CÓMO ESCRIBO ESTO EN TURNOS??


    //..................................EMPTY BUILDER...................................................
    public Patient() {
    }

    //.................................BUILDER WITHOUT ID................................................
    public Patient(String name, String lastName, String dni, LocalDate admissionDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.domicilio = address;
    }
}
