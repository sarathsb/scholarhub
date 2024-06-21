package com.project.scholarhub.answer.repository;

import java.util.List;
import java.util.UUID;

//import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scholarhub.answer.model.Answer;
import com.project.scholarhub.comment.model.Comments;

public interface AnswerRepository  extends JpaRepository<Answer , UUID>{
	List<Answer> findAllByQuestionId(UUID id);
}

