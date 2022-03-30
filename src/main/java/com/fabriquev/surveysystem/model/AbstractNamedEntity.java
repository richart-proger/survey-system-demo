package com.fabriquev.surveysystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class AbstractNamedEntity extends AbstractBaseEntity {

  protected String name;

  AbstractNamedEntity(Integer id, String name) {
    super(id);
    this.name = name;
  }
}
