package com.project.scholarhub.comment.controller;

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

import com.project.scholarhub.comment.model.Comments;
import com.project.scholarhub.comment.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins="http://localhost:3000")

public class CommentController {
	@Autowired
	CommentService service;

	@PostMapping("/comments")
	public Comments addComments(@RequestBody Comments comments)
	{
		return service.addComments(comments);
	}

	@GetMapping()
	public List<Comments> viewComments()
	{
		return service.viewComments();
	}

	@GetMapping("/{id}")
	public List<Comments> viewComment(@PathVariable UUID id)
	{
		return service.viewComment(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteComment(@PathVariable UUID id)
	{
	    return service.deleteComment(id);	
	}
	
	@PutMapping("/{id}")
	public Comments updateComment(@PathVariable UUID id,@RequestBody Comments comments)
	{
		return service.updateComment(id,comments);
	}
	
}
