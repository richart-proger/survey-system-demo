package com.fabriquev.surveysystem.web;

import static com.fabriquev.surveysystem.util.ValidationUtil.assureIdConsistent;
import static com.fabriquev.surveysystem.util.ValidationUtil.checkNew;

import com.fabriquev.surveysystem.model.Question;
import com.fabriquev.surveysystem.model.Survey;
import com.fabriquev.surveysystem.service.QuestionService;
import com.fabriquev.surveysystem.service.SurveyService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController extends AbstractUserController {

  static final String REST_URL = "/api/admin";
  private static final String REST_URL_SURVEYS = "/surveys";
  private static final String REST_URL_QUESTIONS = "/questions";

  private final SurveyService surveyService;
  private final QuestionService questionService;

  @Autowired
  public AdminRestController(SurveyService surveyService,
      QuestionService questionService) {
    this.surveyService = surveyService;
    this.questionService = questionService;
  }

  /**
   * Добавление/изменение/удаление опросов.
   */

  @PostMapping(value = REST_URL_SURVEYS, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Survey createSurvey(@RequestBody @Valid Survey survey) {
    log.info("create survey {}", survey);
    checkNew(survey);
    return surveyService.create(survey);
  }

  @PutMapping(value = REST_URL_SURVEYS + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateSurvey(@RequestBody @Valid Survey survey, @PathVariable int id) {
    log.info("update survey {} with id={}", survey, id);
    assureIdConsistent(survey, id);
    surveyService.update(survey);
  }

  @PutMapping(value = REST_URL_SURVEYS + "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void closeSurvey(@PathVariable int id) {
    log.info("close survey with id={}", id);
    surveyService.close(id);
  }

  @DeleteMapping(REST_URL_SURVEYS + "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteSurvey(@PathVariable int id) {
    log.info("delete survey {}", id);
    surveyService.delete(id);
  }

  @GetMapping(REST_URL_SURVEYS + "/{id}")
  public Survey getSurvey(@PathVariable int id) {
    log.info("get survey by id={}", id);
    return surveyService.get(id);
  }

  @GetMapping(REST_URL_SURVEYS)
  public List<Survey> getAllSurveys() {
    log.info("get all surveys");
    return surveyService.getAll();
  }

  /**
   * Добавление/изменение/удаление вопросов в опросе.
   */

  @PostMapping(value = REST_URL_SURVEYS + "/{surveyId}"
      + REST_URL_QUESTIONS, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Question createQuestion(@RequestBody @Valid Question question,
      @PathVariable int surveyId) {
    log.info("create question {} in survey with id={}", question, surveyId);
    checkNew(question);
    return questionService.create(question, surveyId);
  }

  @PutMapping(value = REST_URL_SURVEYS + "/{surveyId}" + REST_URL_QUESTIONS + "/{questionId}",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateQuestion(@RequestBody @Valid Question question, @PathVariable int surveyId,
      @PathVariable int questionId) {
    log.info("update question {} with id={} in survey with id={}", question, questionId, surveyId);
    assureIdConsistent(question, questionId);
    questionService.update(question, surveyId);
  }

  @DeleteMapping(REST_URL_SURVEYS + "/{surveyId}" + REST_URL_QUESTIONS + "/{questionId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteQuestion(@PathVariable int surveyId, @PathVariable int questionId) {
    log.info("delete question with id={} in survey with id={}", questionId, surveyId);
    questionService.delete(questionId, surveyId);
  }

  @GetMapping(REST_URL_SURVEYS + "/{surveyId}" + REST_URL_QUESTIONS + "/{questionId}")
  public Question getQuestion(@PathVariable int surveyId, @PathVariable int questionId) {
    log.info("get question by questionId={} and surveyId={}", questionId, surveyId);
    return questionService.get(questionId, surveyId);
  }

  @GetMapping(REST_URL_SURVEYS + "/{surveyId}" + REST_URL_QUESTIONS)
  public List<Question> getAllSurveyQuestions(@PathVariable int surveyId) {
    log.info("get all questions with surveyId={}", surveyId);
    return questionService.getAll(surveyId);
  }
}

