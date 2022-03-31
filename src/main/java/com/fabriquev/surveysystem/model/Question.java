package com.fabriquev.surveysystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question extends AbstractBaseEntity {

  @Column(name = "text", nullable = false)
  private String text;

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "question_types", joinColumns = @JoinColumn(name = "question_id"),
      uniqueConstraints = {@UniqueConstraint(columnNames = {"question_id",
          "question_type"}, name = "uk_question_types")})
  @Column(name = "question_type")
  @ElementCollection(fetch = FetchType.EAGER)
  @BatchSize(size = 200)
  private List<QuestionType> questionTypes;

  @JsonIgnore
  @JoinColumn(name = "survey_id", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @BatchSize(size = 200)
  @NotNull
  private Survey survey;

  public Question(Integer id, String text, List<QuestionType> questionTypes, Survey survey) {
    super(id);
    this.text = text;
    this.questionTypes = questionTypes;
    this.survey = survey;
  }
}
