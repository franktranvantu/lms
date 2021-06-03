package com.example.lms.controller;

import com.example.lms.entity.Quiz;
import com.example.lms.service.QuizService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

  private final QuizService quizService;

  public QuizController(QuizService quizService) {
    this.quizService = quizService;
  }

  @GetMapping
  public List<Quiz> searchQuizByNameAndDate(@RequestParam String name, @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
    return quizService.searchQuizByNameAndDate(name, date);
  }

  @PostMapping
  public Quiz createQuiz(@RequestBody Quiz quiz) {
    return quizService.createQuiz(quiz);
  }

  @PutMapping("/{id}")
  public Quiz updateQuiz(@PathVariable Integer id, @RequestBody Quiz quiz) {
    return quizService.updateQuiz(id, quiz);
  }
}
