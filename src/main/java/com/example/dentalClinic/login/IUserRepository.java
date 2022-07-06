/*
package com.example.dentalClinic.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This annotation indicate that the data is stored in the DB
@Repository

//Indicates, can only read users
@Transactional(readOnly=true)

//This extends contains API for basic CRUD operations and also API for pagination and sorting
public interface IUserRepository extends JpaRepository<AppUser, Long> {
      //Find user by email. I put it as optional if it does not find the user
     Optional<AppUser> findByEmail(String email);
}
*/