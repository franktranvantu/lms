package com.example.lms.controller;

import com.example.lms.entity.Answer;
import com.example.lms.service.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

  private final AnswerService answerService;

  public AnswerController(AnswerService answerService) {
    this.answerService = answerService;
  }

  @PostMapping
  public Answer createAnswer(@RequestBody Answer answer) {
    return answerService.createAnswer(answer);
  }

  @PutMapping("/{id}")
  public Answer updateAnswer(@PathVariable Integer id, @RequestBody Answer answer) {
    return answerService.updateAnswer(id, answer);
  }

  @DeleteMapping("/{id}")
  public void deleteAnswer(@PathVariable Integer id) {
    answerService.deleteAnswer(id);
  }
}
