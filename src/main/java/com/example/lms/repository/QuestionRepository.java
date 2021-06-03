package com.example.lms.repository;

import com.example.lms.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

  @Query("SELECT q FROM Question q WHERE q.content LIKE %?1% ORDER BY q.content DESC")
  List<Question> findQuestionsByContent(String content);
}
