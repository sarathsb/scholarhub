package com.project.scholarhub.answer.controller;

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

import com.project.scholarhub.answer.model.Answer;
import com.project.scholarhub.answer.service.AnswerService;

@RestController
@RequestMapping("/answer")
@CrossOrigin("http://localhost:3000")

public class AnswerController {

	@Autowired
	AnswerService service;
	
	@PostMapping("/answers")
	public Answer addAnswer(@RequestBody Answer answer)
	{
		return service.addAnswer(answer);
	}
	
	@GetMapping()
	public List<Answer> viewAnswer(Answer answer)
	{
		return service.viewAnswer();
	}
	
	@GetMapping("/{id}")
	public List<Answer> viewAnswers(@PathVariable UUID id)
	{
		return service.viewAnswers(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAnswer(@PathVariable UUID id)
	{
		return service.deleteAnswer(id);
	}
	
	@PutMapping("/{id}")
	public Answer updateAnswer(@PathVariable UUID id,@RequestBody Answer answer)
	{
		return service.updateAnswer(id,answer);
	}
}
