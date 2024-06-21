package com.project.scholarhub.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scholarhub.user.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	public User findByUserNameAndPassWord(String userName,String passWord);

}
