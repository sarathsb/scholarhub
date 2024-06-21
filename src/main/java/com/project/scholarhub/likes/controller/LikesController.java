package com.project.scholarhub.likes.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scholarhub.likes.model.Likes;
import com.project.scholarhub.likes.service.LikesService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/likes")
public class LikesController {

	@Autowired
	LikesService service;

	@PostMapping
	public Likes insertLike(@RequestBody Likes likes) {

		return service.insertLike(likes);

	}
	
	@GetMapping("/{blogId}/{userId}")
	public Map<String, Object> getLikes(@PathVariable UUID blogId, @PathVariable UUID userId) {

		return service.getLikes(blogId, userId);

	}
	
//	@PostMapping("/{id}")
//	public Likes insertLike(@RequestBody Likes likes, @PathParam("id") UUID id) {
//		likes.setId(id)
//		return service.updateLike(likes);
//
//	}
}
