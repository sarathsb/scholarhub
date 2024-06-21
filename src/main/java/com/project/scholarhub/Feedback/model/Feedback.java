package com.project.scholarhub.Feedback.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ratings")
	private String ratings;

	@Column(name = "message")
	private String message;

	@Column(name = "customer")
	private String userId;

	@Column(name = "restaurant")
	private String restaurantId;
}
