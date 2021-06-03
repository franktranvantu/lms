package com.example.lms.repository;

import com.example.lms.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

  @Query("SELECT q FROM Quiz q WHERE q.name LIKE %?1% AND q.date = ?2 ORDER BY q.name, q.date")
  List<Quiz> findQuizzesByNameAndDateOrderByNameAscDateAsc(String name, LocalDate date);
}
