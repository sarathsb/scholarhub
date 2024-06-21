package com.project.scholarhub.comment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.scholarhub.comment.model.Comments;

public interface CommentRepository extends JpaRepository <Comments,UUID>
{
List<Comments> findAllByBlogId(UUID id);
@Query(value = "SELECT blog_id from (select blog_id, count(*) from comments group by  blog_id order by count desc)", nativeQuery = true)
List<UUID> getTrendingBlogs();

void deleteAllByBlogId(UUID id);
}
