package com.project.scholarhub.likes.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.likes.model.Likes;
import com.project.scholarhub.likes.repository.LikesRepository;

@Service
public class LikesService {

	@Autowired
	LikesRepository repo;
	public Likes insertLike(Likes likes) {
		Likes savedLikesEntry = repo.save(likes);
		return savedLikesEntry;
	}
	
	public Map<String, Object> getLikes(UUID blogId, UUID userId) {
		Likes likesEntryRetrieved = null;
		try {
			 likesEntryRetrieved = repo.findByBlogIdAndUserId(blogId, userId);
		}catch(Exception e) {
			System.out.println("Error occured while fetching likes from DB"+ e.getMessage());
		}
		Long count = repo.countByBlogIdAndIsLiked(blogId, true);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("count", count);
		dataMap.put("likesEntryRetrieved", likesEntryRetrieved);
		return dataMap;
	}
}
