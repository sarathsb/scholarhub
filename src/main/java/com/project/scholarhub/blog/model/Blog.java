package com.project.scholarhub.blog.model;



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
@Table (name="Blogs")

public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String title;
	private UUID author;
	private Date date= new Date();
	@Lob
	private String content;
	private String category;
	@Lob
	private byte[] image;
	
	
}
