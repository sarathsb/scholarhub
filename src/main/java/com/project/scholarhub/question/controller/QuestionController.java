package com.project.scholarhub.question.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scholarhub.question.model.Question;
import com.project.scholarhub.question.service.QuestionService;

@RestController
@RequestMapping("/questions")
@CrossOrigin("http://localhost:3000")

public class QuestionController {
	@Autowired
	QuestionService service;
	
	@PostMapping("/addquestion")
	public Question addQuestion(@RequestBody Question question)
	{
		return service.addQuestion(question);
	}
	
	@GetMapping("")
	public List<Question> viewQuestion( Question question)
	{
		return service.viewQuestion(question);
	}

	@GetMapping("/{id}")
	public Question viewQuestions(@PathVariable UUID id)
	{
		return service.viewQuestions(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteQuestion(@PathVariable UUID id)
	{
		return service.deleteQuestion(id);
	}
	
	@PutMapping("/{id}")
	public Question updateQuestion(@PathVariable UUID id,@RequestBody Question question)
	{
		return service.updateQuestion(id,question);
	}
}