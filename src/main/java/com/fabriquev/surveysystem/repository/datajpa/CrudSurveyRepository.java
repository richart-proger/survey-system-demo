package com.fabriquev.surveysystem.repository.datajpa;

import com.fabriquev.surveysystem.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudSurveyRepository extends JpaRepository<Survey, Integer> {

  @Transactional
  @Modifying
  @Query("DELETE FROM Survey u WHERE u.id=?1")
  int delete(int id);
}
