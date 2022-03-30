package com.fabriquev.surveysystem.repository;

import com.fabriquev.surveysystem.model.Survey;
import java.util.List;

public interface SurveyRepository {

  // null if not found, when updated
  Survey save(Survey survey);

  // false if not found
  boolean delete(int id);

  // null if not found
  Survey get(int id);

  List<Survey> getAll();
}
