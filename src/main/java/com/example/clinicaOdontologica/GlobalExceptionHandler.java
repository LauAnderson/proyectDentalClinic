package com.example.clinicaOdontologica;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//Annotation to handle exceptions
@ControllerAdvice
public class GlobalExceptionHandler {

    //Initialize the loggers
    private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    public ResponseEntity<?> allErrors (Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        //HttpStatus.INTERNAL_SERVER_ERROR: to show us the error on the screen in the message
        return new ResponseEntity("Error " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
