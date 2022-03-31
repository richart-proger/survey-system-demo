package com.fabriquev.surveysystem.service;

import static com.fabriquev.surveysystem.util.ValidationUtil.checkNotFoundWithId;

import com.fabriquev.surveysystem.model.Question;
import com.fabriquev.surveysystem.repository.QuestionRepository;
import com.fabriquev.surveysystem.repository.SurveyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private QuestionRepository questionRepository;
  private SurveyRepository surveyRepository;

  @Autowired
  public QuestionService(QuestionRepository questionRepository,
      SurveyRepository surveyRepository) {
    this.questionRepository = questionRepository;
    this.surveyRepository = surveyRepository;
  }

  public Question create(Question question, int surveyId) {
    question.setSurvey(surveyRepository.get(surveyId));
    return questionRepository.save(question);
  }

  public void update(Question question, int surveyId) {
    question.setSurvey(surveyRepository.get(surveyId));
    checkNotFoundWithId(questionRepository.save(question), question.getId());
  }

  public void delete(int id, int surveyId) {
    checkNotFoundWithId(questionRepository.delete(id, surveyId), id);
  }

  public Question get(int id, int surveyId) {
    return checkNotFoundWithId(questionRepository.get(id, surveyId), id);
  }

  public List<Question> getAll(int surveyId) {
    return questionRepository.getAll(surveyId);
  }
}
