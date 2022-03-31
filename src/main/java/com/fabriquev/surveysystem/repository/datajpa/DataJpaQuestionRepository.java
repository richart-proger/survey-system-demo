package com.fabriquev.surveysystem.repository.datajpa;

import com.fabriquev.surveysystem.model.Question;
import com.fabriquev.surveysystem.repository.QuestionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaQuestionRepository implements QuestionRepository {

  private final CrudQuestionRepository crudQuestionRepository;

  @Autowired
  public DataJpaQuestionRepository(CrudQuestionRepository crudQuestionRepository) {
    this.crudQuestionRepository = crudQuestionRepository;
  }

  @Override
  public Question save(Question question) {
    return crudQuestionRepository.save(question);
  }

  @Override
  public boolean delete(int id, int surveyId) {
    return crudQuestionRepository.deleteBySurveyId(id, surveyId) != 0;
  }

  @Override
  public Question get(int id, int surveyId) {
    return crudQuestionRepository.getBySurveyId(id, surveyId);
  }

  @Override
  public List<Question> getAll(int surveyId) {
    return crudQuestionRepository.getAllBySurveyId(surveyId);
  }
}
