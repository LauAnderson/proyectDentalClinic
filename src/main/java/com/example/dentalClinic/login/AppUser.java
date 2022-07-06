/*
package com.example.dentalClinic.login;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//I use the annotation to indicate that this class is an Entity
@Entity

//....................................GETTER AND SETTERS...............................................
//With this annotation generate automatically getters and setters
@Getter
@Setter

public class AppUser implements UserDetails {
  //....................................ATTRIBUTES...................................................
  //These annotations are used to indicate that this is the id in the DB table
  //We make the configurations of its value
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private String userName;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private AppUserRole userRole;

  //..................................EMPTY BUILDER...................................................
  public AppUser() {
  }

  //.................................BUILDER WITHOUT ID................................................
  public AppUser(String userName, String email, String password, AppUserRole userRole) {
      this.userName = userName;
      this.email = email;
      this.password = password;
      this.userRole = userRole;
  }

  //............................OVERRIDE METHODS OF USERDETAILS........................................
  @Override
  //Indicate with the list the permissions that user granted
  public Collection<? extends GrantedAuthority> getAuthorities() {
      SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUserRole.name());
      return Collections.singletonList(grantedAuthority);
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

   */
