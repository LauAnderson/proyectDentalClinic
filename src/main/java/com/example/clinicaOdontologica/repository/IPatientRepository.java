package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This annotation indicate that the data is stored in the DB
@Repository

//This extends contains API for basic CRUD operations and also API for pagination and sorting
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    //Acá haría las querys y en service haría un método para llamarlas
}
