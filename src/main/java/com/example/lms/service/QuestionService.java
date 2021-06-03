package com.example.lms.service;

import com.example.lms.entity.Question;
import com.example.lms.entity.Quiz;
import com.example.lms.repository.QuestionRepository;
import com.example.lms.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final QuizRepository quizRepository;

  public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
    this.questionRepository = questionRepository;
    this.quizRepository = quizRepository;
  }

  public List<Question> searchQuestionByContent(String content) {
    return questionRepository.findQuestionsByContent(content);
  }

  public Question createQuestion(Question question) {
    Quiz quiz = quizRepository.findById(question.getQuiz().getId()).orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
    question.setQuiz(quiz);
    return questionRepository.save(question);
  }

  public Question updateQuestion(Integer id, Question question) {
    Question existQuestion = questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found"));
    Quiz quiz = quizRepository.findById(question.getQuiz().getId()).orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
    existQuestion.setQuiz(quiz);
    existQuestion.setContent(question.getContent());
    return questionRepository.save(existQuestion);
  }

  public void deleteQuestion(Integer id) {
    questionRepository.deleteById(id);
  }
}
