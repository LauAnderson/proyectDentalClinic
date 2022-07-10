package com.example.dentalClinic.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String tuition;

    //FetchType.LAZY: the object is initialized only when required
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Appointment> appointments = new ArrayList<>();

    public Dentist() {
    }

    public Dentist(String name, String lastName, String tuition) {
        this.name = name;
        this.lastName = lastName;
        this.tuition = tuition;
    }
}
