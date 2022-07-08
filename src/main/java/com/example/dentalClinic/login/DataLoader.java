/*
package com.example.dentalClinic.login;

//Is an annotation that allows Spring to automatically detect our custom beans.
@Component
public class DataLoader implements ApplicationRunner{

     //................................DEPENDENCY INJECTION.........................................
    //With this annotation indicate that it brings the dependencies of IDentistRepository interface of
    //repository package
    @Autowired
    IUserRepository userRepository;


    //.........................OVERRIDE METHOD OF APPLICATIONRUNNER................................
    //method to encrypt the password
     @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passAdmin = passwordEncoder.encode("adminPassword");
        String passUser = passwordEncoder.encode("userPassword");

        userRepository.save(new AppUser("admin", "admin", "admin", password, AppUserRole.ROLE_ADMIN));
        userRepository.save(new AppUser("user", "user", "user", password2, AppUserRole.ROLE_USER));
    }
}
*/