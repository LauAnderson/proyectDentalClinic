/*
package com.example.dentalClinic.login;
//Tells to Spring that before starting the app it must load the configuration
@Configuration

//Indicates control the security of the entire project
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

     //................................DEPENDENCY INJECTION.........................................
     //With this annotation indicate that it brings the dependencies of AppUSerService
    @Autowired
    private AppUserService userService;

    //Indicates that injection the dependency of bean (in this case the method to encrypt the password)
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //......................OVERRIDE METHOD OF WEBSECURITYCONFIGURERADAPTER..........................
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").hasAnyAuthority(AppUserRole.ROLE_USER.name())
                .antMatchers("/admin/**").hasAnyAuthority(AppUserRole.ROLE_ADMIN.name())
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().httpBasic()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
*/