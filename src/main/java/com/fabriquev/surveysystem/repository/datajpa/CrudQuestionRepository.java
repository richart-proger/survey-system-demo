package com.fabriquev.surveysystem.repository.datajpa;

import com.fabriquev.surveysystem.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudQuestionRepository extends JpaRepository<Question, Integer> {

  @EntityGraph(attributePaths = {"survey", "questionTypes"})
  @Query("SELECT q FROM Question q WHERE q.survey.id=:surveyId ORDER BY q.id ASC")
  List<Question> getAllBySurveyId(@Param("surveyId") int surveyId);

  @Query("SELECT q FROM Question q WHERE q.id=:questionId AND q.survey.id=:surveyId")
  Question getBySurveyId(@Param("questionId") int questionId, @Param("surveyId") int surveyId);

  @Transactional
  @Modifying
  @Query("DELETE FROM Question q WHERE q.id=:questionId AND q.survey.id=:surveyId")
  int deleteBySurveyId(@Param("questionId") int questionId, @Param("surveyId") int surveyId);
}
