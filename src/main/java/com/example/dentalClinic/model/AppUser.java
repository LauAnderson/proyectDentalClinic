package com.example.dentalClinic.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
@Getter
@Setter
@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole userRole;

    public AppUser() {
    }

    public AppUser(String userName, String email, String password, AppUserRole userRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    //Indicate with the list the permissions that user granted
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    //Hark to methods return true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
