package com.project.scholarhub.question.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.question.model.Question;
import com.project.scholarhub.question.repository.QuestionRepository;

@Service
public class QuestionService {
	
    @Autowired
	QuestionRepository repository;
	
	public Question addQuestion(Question question)
	{
		return repository.save(question);
	}
	public List<Question> viewQuestion(Question question)
	{
		return repository.findAll();
	}
	public Question viewQuestions(UUID id)
	{
		Optional<Question>question ;
		question=repository.findById(id);
		return question.get();
	}

	public String deleteQuestion(UUID id)
	{
		repository.deleteById(id);
		return "deleted";
	}
	
	public Question updateQuestion(UUID id,Question question)
	{
		return repository.save(question);
	}
}
