package com.project.scholarhub.question.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scholarhub.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID>{

}
