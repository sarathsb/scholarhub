package com.project.scholarhub.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.blog.model.Blog;
import com.project.scholarhub.blog.repository.BlogRepository;
import com.project.scholarhub.comment.repository.CommentRepository;
import com.project.scholarhub.likes.repository.LikesRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
	@Autowired
	BlogRepository repository;
	
	@Autowired
	LikesRepository likeRepository;
	
	@Autowired
	CommentRepository commentRepository;

	public Blog saveBlog(Blog blog) {
		return repository.save(blog);
	}

//	@SuppressWarnings("deprecation")
	public List<Blog> viewBlogs(String type) {
		List<Blog> blogList = new ArrayList<>();
		if ("latest".equals(type)) {
			return repository.findTop10ByOrderByDateDesc();
		} else if ("trending".equals(type)) {
			
			List<UUID>  dataMap = commentRepository.getTrendingBlogs();
			dataMap.stream().forEachOrdered(uuid -> blogList.add(repository.findById(uuid).get()));
			return blogList;
		} else if ("popular".equals(type)) {
			
			List<UUID>  dataMap = likeRepository.getPopularBlogs();
			
			dataMap.stream().forEachOrdered(uuid -> blogList.add(repository.findById(uuid).get()));
			return blogList;
//			return repository.findAllById(dataMap);
			
			
			
//			return repository.findAll();
		} else {
			return repository.findAll();
		}
	}

	public Blog viewBlog(UUID id) {
		Optional<Blog> blog;
		blog = repository.findById(id);
		return blog.get();

	}
@Transactional
	public String deleteBlog(UUID id) {
		repository.deleteById(id);
		likeRepository.deleteAllByBlogId(id);
		commentRepository.deleteAllByBlogId(id);
		return "deleted";
	}

	public Blog updateBlog(UUID id, Blog blog) {
		return repository.save(blog);
	}
}
