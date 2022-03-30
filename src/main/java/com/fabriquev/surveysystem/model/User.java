package com.fabriquev.surveysystem.model;

import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class User extends AbstractNamedEntity {

  private String email;
  private String password;
  private boolean enabled = true;
  private Date registered = new Date();
  private Set<Role> roles;

  public User(String email, String password, boolean enabled, Date registered,
      Set<Role> roles) {
    this.email = email;
    this.password = password;
    this.enabled = enabled;
    this.registered = registered;
    this.roles = roles;
  }

  public User(Integer id, String name, String email, String password, boolean enabled,
      Date registered, Set<Role> roles) {
    super(id, name);
    this.email = email;
    this.password = password;
    this.enabled = enabled;
    this.registered = registered;
    this.roles = roles;
  }
}
