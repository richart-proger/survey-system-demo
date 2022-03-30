package com.fabriquev.surveysystem.web;

import static com.fabriquev.surveysystem.util.ValidationUtil.assureIdConsistent;
import static com.fabriquev.surveysystem.util.ValidationUtil.checkNew;

import com.fabriquev.surveysystem.model.Question;
import com.fabriquev.surveysystem.model.Survey;
import com.fabriquev.surveysystem.service.QuestionService;
import com.fabriquev.surveysystem.service.SurveyService;

public class AdminRestController extends AbstractUserController {

  private SurveyService surveyService;
  private QuestionService questionService;

  /**
   * добавление/изменение/удаление опросов.
   */
  public Survey createSurvey(Survey survey) {
    log.info("create survey {}", survey);
    checkNew(survey);
    return surveyService.create(survey);
  }

  public void updateSurvey(Survey survey, int id) {
    log.info("update survey {} with id={}", survey, id);
    assureIdConsistent(survey, id);
    surveyService.update(survey);
  }

  public void deleteSurvey(int id) {
    log.info("delete survey {}", id);
    surveyService.delete(id);
  }

  /**
   * добавление/изменение/удаление вопросов в опросе.
   */
  public Question createQuestion(Question question, Survey survey) {
    log.info("create question {} in survey {}", question, survey);
    checkNew(question);
    return questionService.create(question, survey);
  }

  public void updateQuestion(Question question, int id, Survey survey) {
    log.info("update question {} with id={} in survey {}", question, id, survey);
    assureIdConsistent(question, id);
    questionService.update(question, survey);
  }

  public void deleteQuestion(int id, Survey survey) {
    log.info("delete question {} in survey {}", id, survey);
    questionService.delete(id, survey);
  }
}

