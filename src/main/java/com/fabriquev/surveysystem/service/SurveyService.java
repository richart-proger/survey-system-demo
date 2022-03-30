package com.fabriquev.surveysystem.service;

import static com.fabriquev.surveysystem.util.ValidationUtil.checkNotFoundWithId;

import com.fabriquev.surveysystem.model.Survey;
import com.fabriquev.surveysystem.repository.SurveyRepository;
import java.util.List;

public class SurveyService {

  private SurveyRepository surveyRepository;

  public Survey create(Survey survey) {
    return surveyRepository.save(survey);
  }

  public void update(Survey survey) {
    checkNotFoundWithId(surveyRepository.save(survey), survey.getId());
  }

  public void delete(int id) {
    checkNotFoundWithId(surveyRepository.delete(id), id);
  }

  public Survey get(int id) {
    return checkNotFoundWithId(surveyRepository.get(id), id);
  }

  public List<Survey> getAll() {
    return surveyRepository.getAll();
  }
}
