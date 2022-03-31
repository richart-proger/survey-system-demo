package com.fabriquev.surveysystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "surveys")
public class Survey extends AbstractNamedEntity {

  @Column(name = "start_date", nullable = false, columnDefinition = "date default now()")
  @NotNull
  private final Date startDate = new Date();

  @Column(name = "finish_date")
  private Date finishDate;

  @Column(name = "description", nullable = false)
  private String description;

  @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
  @OrderBy("id asc")
  @JsonIgnore
  private List<Question> questions;

  public Survey(Integer id, String name, Date finishDate, String description,
      List<Question> questions) {
    super(id, name);
    this.finishDate = finishDate;
    this.description = description;
    this.questions = questions;
  }
}
