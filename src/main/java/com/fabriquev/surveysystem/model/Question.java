package com.fabriquev.surveysystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Question extends AbstractBaseEntity {

  private String text;
  private QuestionType type;

  public Question(Integer id, String text, QuestionType type) {
    super(id);
    this.text = text;
    this.type = type;
  }
}
