package com.project.scholarhub.answer.model;


import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name ="Answers")

public class Answer {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	private UUID id;   
	private UUID questionId;
	private String answer;
	private String author;
	private Date date=new Date();
}
