package com.fabriquev.surveysystem.repository;

import com.fabriquev.surveysystem.model.Question;
import com.fabriquev.surveysystem.model.Survey;
import java.util.List;

public interface QuestionRepository {

  // null if not found, when updated
  Question save(Question question, Survey survey);

  // false if not found
  boolean delete(int id, Survey survey);

  // null if not found
  Question get(int id, Survey survey);

  List<Question> getAll(Survey survey);
}
