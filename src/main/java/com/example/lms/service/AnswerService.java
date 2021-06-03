package com.example.lms.service;

import com.example.lms.entity.Answer;
import com.example.lms.entity.Question;
import com.example.lms.repository.AnswerRepository;
import com.example.lms.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

  private final AnswerRepository answerRepository;
  private final QuestionRepository questionRepository;

  public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
    this.answerRepository = answerRepository;
    this.questionRepository = questionRepository;
  }

  public Answer createAnswer(Answer answer) {
    Question question = questionRepository.findById(answer.getQuestion().getId()).orElseThrow(() -> new IllegalArgumentException("Question not found"));
    answer.setQuestion(question);
    return answerRepository.save(answer);
  }

  public Answer updateAnswer(Integer id, Answer answer) {
    Answer existAnswer = answerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Answer not found"));
    Question question = questionRepository.findById(answer.getQuestion().getId()).orElseThrow(() -> new IllegalArgumentException("Question not found"));
    existAnswer.setQuestion(question);
    existAnswer.setContent(answer.getContent());
    existAnswer.setCorrectAnswer(answer.isCorrectAnswer());
    return answerRepository.save(existAnswer);
  }

  public void deleteAnswer(Integer id) {
    answerRepository.deleteById(id);
  }
}
