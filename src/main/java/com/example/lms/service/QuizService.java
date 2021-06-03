package com.example.lms.service;

import com.example.lms.entity.Quiz;
import com.example.lms.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

  private final QuizRepository quizRepository;

  public QuizService(QuizRepository quizRepository) {
    this.quizRepository = quizRepository;
  }

  public List<Quiz> searchQuizByNameAndDate(String name, LocalDate date) {
    return quizRepository.findQuizzesByNameAndDateOrderByNameAscDateAsc(name, date);
  }

  public Quiz createQuiz(Quiz quiz) {
    return quizRepository.save(quiz);
  }

  public Quiz updateQuiz(Integer id, Quiz quiz) {
    Quiz existQuiz = quizRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
    existQuiz.setName(quiz.getName());
    existQuiz.setDate(quiz.getDate());
    return quizRepository.save(existQuiz);
  }
}
