package com.fabriquev.surveysystem.repository.datajpa;

import com.fabriquev.surveysystem.model.Survey;
import com.fabriquev.surveysystem.repository.SurveyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaSurveyRepository implements SurveyRepository {

  private static final Sort SORT_BY_DATE = Sort.by(Direction.DESC, "startDate");

  private final CrudSurveyRepository crudSurveyRepository;

  @Autowired
  public DataJpaSurveyRepository(
      CrudSurveyRepository crudSurveyRepository) {
    this.crudSurveyRepository = crudSurveyRepository;
  }

  @Override
  public Survey save(Survey survey) {
    return crudSurveyRepository.save(survey);
  }

  @Override
  public boolean delete(int id) {
    return crudSurveyRepository.delete(id) != 0;
  }

  @Override
  public Survey get(int id) {
    return crudSurveyRepository.findById(id).orElse(null);
  }

  @Override
  public List<Survey> getAll() {
    return crudSurveyRepository.findAll(SORT_BY_DATE);
  }
}
