package com.project.scholarhub.likes.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.scholarhub.likes.model.Likes;


public interface LikesRepository extends JpaRepository<Likes, UUID>{
 Likes findByBlogIdAndUserId(UUID blogId,UUID userId);
 Long countByBlogIdAndIsLiked(UUID blogId, boolean liked);
// @Query("select blog_id from likes where is_liked=true group by blog_id")
 
 
// @Query(value = "SELECT blog_id, count(*) as like_count FROM likes WHERE is_liked='true' group by blog_id", nativeQuery = true)
// @ColumnResult(resultName = "BlogLikeCountMapping")
 @Query(value = "select blog_id from (select blog_id, count(*) from likes where is_liked is true group by  blog_id order by count desc)", nativeQuery = true)
 List<UUID> getPopularBlogs();
 
 void deleteAllByBlogId(UUID id);
}
