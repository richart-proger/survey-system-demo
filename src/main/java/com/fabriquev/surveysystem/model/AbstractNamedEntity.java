package com.fabriquev.surveysystem.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@MappedSuperclass
public class AbstractNamedEntity extends AbstractBaseEntity {

  @NotBlank
  @Size(min = 2, max = 100)
  @Column(name = "name", nullable = false)
  protected String name;

  AbstractNamedEntity(Integer id, String name) {
    super(id);
    this.name = name;
  }
}
