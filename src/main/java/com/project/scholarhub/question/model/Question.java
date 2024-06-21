package com.project.scholarhub.question.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Questions")

public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String Question;
	private UUID Author;
	private Date date=new Date();
	@Lob
	private String description;
	
	

}
