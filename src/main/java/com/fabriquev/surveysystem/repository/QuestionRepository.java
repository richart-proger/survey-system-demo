package com.fabriquev.surveysystem.repository;

import com.fabriquev.surveysystem.model.Question;
import java.util.List;

public interface QuestionRepository {

  // null if not found, when updated
  Question save(Question question);

  // false if not found
  boolean delete(int id, int surveyId);

  // null if not found
  Question get(int id, int surveyId);

  List<Question> getAll(int surveyId);
}
