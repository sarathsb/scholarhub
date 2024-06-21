package com.project.scholarhub.Feedback.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.Feedback.model.Feedback;
import com.project.scholarhub.Feedback.repository.FeedbackRepository;

@Service

public class FeedbackService {

	@Autowired
	FeedbackRepository repository;
	
	public Feedback addrating(Feedback feedback)
	{
		return repository.save(feedback);
	}
	
	public List<Feedback> listFeedback()
	{
		return repository.findAll();
	}
}

//	if (feeback.message == null)
//	{
//		return repository.save("null");
//	}
