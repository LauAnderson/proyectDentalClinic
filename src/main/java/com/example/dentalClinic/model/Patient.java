package com.example.dentalClinic.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate admissionDate;

    @OneToOne(cascade = CascadeType.ALL)
    //With the JoinColumn annotation I indicate the mapping to the Address table through the id
    //This id in this table is a foreign key
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments = new ArrayList<>();

    public Patient() {
    }

    public Patient(String name, String lastName, String dni, LocalDate admissionDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
    }
}

