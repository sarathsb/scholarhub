package com.project.scholarhub.comment.model;


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
@Table(name="comments")


public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private UUID blogId;
	private String comment;
    private String author;
    private Date date=new Date();
    

}
