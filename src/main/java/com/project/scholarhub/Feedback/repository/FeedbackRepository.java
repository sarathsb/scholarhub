package com.project.scholarhub.Feedback.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scholarhub.Feedback.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
