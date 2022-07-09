package com.example.dentalClinic.exceptions;

import lombok.Getter;

@Getter
//This is class is use it in body response in exception message
public class ResponseBodyError {
    private String message;

    public ResponseBodyError(String message) {
        this.message = message;
    }
}
