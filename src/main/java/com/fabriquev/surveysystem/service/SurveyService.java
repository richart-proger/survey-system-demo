package com.fabriquev.surveysystem.service;

import static com.fabriquev.surveysystem.util.ValidationUtil.checkNotFoundWithId;

import com.fabriquev.surveysystem.model.Survey;
import com.fabriquev.surveysystem.repository.SurveyRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

  private final SurveyRepository surveyRepository;

  @Autowired
  public SurveyService(SurveyRepository surveyRepository) {
    this.surveyRepository = surveyRepository;
  }

  public Survey create(Survey survey) {
    return surveyRepository.save(survey);
  }

  public void update(Survey survey) {
    checkNotFoundWithId(surveyRepository.save(survey), survey.getId());
  }

  public void close(int id) {
    Survey survey = get(id);
    survey.setFinishDate(new Date());
    update(survey);
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
