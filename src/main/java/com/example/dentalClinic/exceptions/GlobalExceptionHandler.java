package com.example.dentalClinic.exceptions;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//In this class generate a method for error http 500 and http 404. Indicate with the attribute static that logger the
//error use it log4j. And show the response in the file: dentalClinic_errors.log
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> processAllErrorNotFound(Exception ex, WebRequest req) {
        logger.error(ex.getMessage());
        //I pass an object so that the response is a JSON
        return new ResponseEntity(new ResponseBodyError(ex.getMessage()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> processAllError(Exception ex, WebRequest req) {
        logger.error(ex.getMessage());
        return new ResponseEntity(new ResponseBodyError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
