/*
package com.example.dentalClinic.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//This annotation indicate that the class belongs to the service layer
@Service

public class AppUserService implements UserDetailsService {

    //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IDentistRepository interface of
    //repository package
    @Autowired
    IUserRepository userRepository;

    //.........................OVERRIDE METHOD OF USERDETAILSSERVICE................................
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <AppUser> searchUser = userRepository.findByEmail(email);
        if(searchUser.isPresent()){
            //This return AppUser. And as Appuser implements UserDetails by polymorphism it returns it to me
            return searchUser.get();
        }
        else{
            throw new UserNameNotFoundException("User email not found");
        }
    }

}
*/