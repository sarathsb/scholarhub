package com.project.scholarhub.user.model;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "Users")


public class User {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
private String firstName;
private String lastName;
private String email;
private String phnNo;
@Column(unique=true)
private String userName;
private String passWord;
private String gender;
private String role = "user";
}
