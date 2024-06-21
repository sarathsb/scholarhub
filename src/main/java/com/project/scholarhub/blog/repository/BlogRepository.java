package com.project.scholarhub.blog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scholarhub.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, UUID>{

	List<Blog> findTop10ByOrderByDateDesc();
}
