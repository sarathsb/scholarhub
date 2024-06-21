package com.project.scholarhub.likes.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Likes")
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private UUID blogId;
	private UUID userId;
	private boolean isLiked;
}
