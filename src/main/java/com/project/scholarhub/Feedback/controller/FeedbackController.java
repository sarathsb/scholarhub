package com.project.scholarhub.Feedback.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scholarhub.Feedback.model.Feedback;
import com.project.scholarhub.Feedback.service.FeedbackService;

@RestController
@RequestMapping("/feedback")

public class FeedbackController {

	@Autowired
	FeedbackService service;
	
	@PostMapping("/add")
	public Feedback addrating(@RequestBody Feedback feedback)
	{
		return service.addrating(feedback);
	}
	
	@GetMapping
	public List<Feedback> listFeedback()
	{
		return service.listFeedback();
	}
}
