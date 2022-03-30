package com.fabriquev.surveysystem.model;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Survey extends AbstractNamedEntity {

  private final Date startDate = new Date();
  private Date finishDate;
  private String description;

  public Survey(Integer id, String name, Date finishDate, String description) {
    super(id, name);
    this.finishDate = finishDate;
    this.description = description;
  }
}
