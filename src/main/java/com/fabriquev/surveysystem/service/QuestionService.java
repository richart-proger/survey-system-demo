package com.fabriquev.surveysystem.service;

import static com.fabriquev.surveysystem.util.ValidationUtil.checkNotFoundWithId;

import com.fabriquev.surveysystem.model.Question;
import com.fabriquev.surveysystem.model.Survey;
import com.fabriquev.surveysystem.repository.QuestionRepository;
import java.util.List;

public class QuestionService {

  private QuestionRepository questionRepository;

  public Question create(Question question, Survey survey) {
    return questionRepository.save(question, survey);
  }

  public void update(Question question, Survey survey) {
    checkNotFoundWithId(questionRepository.save(question, survey), question.getId());
  }

  public void delete(int id, Survey survey) {
    checkNotFoundWithId(questionRepository.delete(id, survey), id);
  }

  public Question get(int id, Survey survey) {
    return checkNotFoundWithId(questionRepository.get(id, survey), id);
  }

  public List<Question> getAll(Survey survey) {
    return questionRepository.getAll(survey);
  }
}
