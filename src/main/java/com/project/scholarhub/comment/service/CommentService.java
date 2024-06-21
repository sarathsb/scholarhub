package com.project.scholarhub.comment.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.comment.model.Comments;
import com.project.scholarhub.comment.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository repository;
	
	public Comments addComments(Comments comments)
	{
		return repository.save(comments);
	}
	public List<Comments> viewComments()
	{
		return repository.findAll();	
	}
	public List<Comments> viewComment(UUID id)
	{
//		Optional<Comments> comments;
		List<Comments> comments = repository.findAllByBlogId(id);
		return comments;
		
	}
	
	public String deleteComment(UUID id)
	{
		repository.deleteById(id);
	    return"deleted";
	}
	
	public Comments updateComment(UUID id,Comments comments)
	{
		return repository.save(comments);
	}
	
}

