package com.example.dentalClinic.exceptions;

//This class extends from java extends class which in turn extends from Throwable
public class ResourceNotFoundException extends Exception{

    //..................................BUILDER.........................................
    public ResourceNotFoundException (String mesage){
        super(mesage);
    }

}
