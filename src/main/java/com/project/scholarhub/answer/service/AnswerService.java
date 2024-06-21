package com.project.scholarhub.answer.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.answer.model.Answer;
import com.project.scholarhub.answer.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository repository;
	
    public Answer addAnswer(Answer answer)
    {
    	return repository.save(answer);
    }
    
    public List<Answer> viewAnswer()
    {
    	return repository.findAll();
    }
 
    public List<Answer> viewAnswers(UUID id)
    {
    	List<Answer>answer;
    	answer=repository.findAllByQuestionId(id);
    	return answer;
    	
    }
    
    public String deleteAnswer(UUID id)
    {
    	repository.deleteById(id);
    	return "deleted";
    }
    
    public Answer updateAnswer(UUID id,Answer answer)
    {
    	return repository.save(answer);    }
}

