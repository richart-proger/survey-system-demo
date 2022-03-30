package com.fabriquev.surveysystem.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class AbstractBaseEntity {

  protected Integer id;

  public boolean isNew() {
    return this.id == null;
  }
}
