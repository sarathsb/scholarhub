package com.project.scholarhub.blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scholarhub.blog.model.Blog;
import com.project.scholarhub.blog.service.BlogService;

@CrossOrigin(origins="http://localhost:3000")


@RestController
@RequestMapping("/blogs")

public class BlogController {
	@Autowired
	BlogService service;
	
	@PostMapping(path="blog", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Blog saveBlog(@ModelAttribute Blog blog, @RequestParam("titleImage") MultipartFile file) throws IOException
	{
	    blog.setImage(file.getBytes());
		return service.saveBlog(blog);
	}
	
	@GetMapping()
	public List<Blog> viewBlogs(@RequestParam String type)
	{
		return service.viewBlogs(type);
	}
	
	@GetMapping("/{id}")
	public Blog viewBlog(@PathVariable UUID id)
	{
		return service.viewBlog(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBlog(@PathVariable UUID id)
	{
		return service.deleteBlog(id);
	}

	@PutMapping("/{id}")
	public Blog updateBlog(@PathVariable UUID id,@RequestBody Blog blog )
	{
		return service.updateBlog(id,blog);
	}
}
