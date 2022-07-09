package com.example.dentalClinic.login;

import com.example.dentalClinic.model.AppUser;
import com.example.dentalClinic.model.AppUserRole;
import com.example.dentalClinic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//Is an annotation that allows Spring to automatically detect our custom beans.
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    IUserRepository userRepository;

     @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passAdmin = passwordEncoder.encode("1234");
        String passUser = passwordEncoder.encode("1234");

        userRepository.deleteAll();

        userRepository.save(new AppUser("admin", "admin@email.com", passAdmin, AppUserRole.ROLE_ADMIN));
        userRepository.save(new AppUser("user", "user@email.com", passUser, AppUserRole.ROLE_USER));
    }
}
