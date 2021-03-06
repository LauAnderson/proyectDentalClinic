package com.example.dentalClinic.repository;
import com.example.dentalClinic.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This annotation indicate that the data is stored in the DB
@Repository
//This extends contains API for basic CRUD operations and also API for pagination and sorting
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
