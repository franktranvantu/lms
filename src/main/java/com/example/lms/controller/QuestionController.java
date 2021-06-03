package com.example.lms.controller;

import com.example.lms.entity.Question;
import com.example.lms.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

  private final QuestionService questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping
  public List<Question> searchQuestionByContent(@RequestParam String content) {
    return questionService.searchQuestionByContent(content);
  }

  @PostMapping
  public Question createQuestion(@RequestBody Question question) {
    return questionService.createQuestion(question);
  }

  @PutMapping("/{id}")
  public Question updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
    return questionService.updateQuestion(id, question);
  }

  @DeleteMapping("/{id}")
  public void deleteQuestion(@PathVariable Integer id) {
    questionService.deleteQuestion(id);
  }
}
