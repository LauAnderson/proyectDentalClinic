package com.example.dentalClinic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

//....................................GETTER AND SETTERS..............................................
//With this annotation generate automatically getters and setters
@Getter
@Setter

//Tells to ignore properties that are not required
@JsonIgnoreProperties(ignoreUnknown = true)

//DTO are objects that carry data between processes in order to reduce the number of methods calls
//They are flat data structures that contain no business logic
public class AddressDto {

    //....................................ATTRIBUTES...................................................
    private Long id;
    private String street;
    private Integer number;
    private String location;
    private String province;


    //..................................EMPTY BUILDER...................................................
    public AddressDto() {
    }
}
