package com.project.scholarhub.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scholarhub.user.model.User;
import com.project.scholarhub.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	public User registerUser(User user) throws Exception
	{
		try{return repository.save(user);}
		catch(Exception ex)
		{
			throw new Exception("Username Already Taken");
			
		}
	}
	
	public List<User> listUser()
	{
		return repository.findAll();
	}
	
	public String deleteUser(UUID id)
	{
		repository.deleteById(id);
		return "user deleted successfully:";
	}
	
	public User listUser(UUID id)
	{
		Optional<User> user;
		user=repository.findById(id);
		return user.get();	
	}
	
	public User updateUser(UUID id,User user)
	{
		user.setId(id);
		return repository.save(user);
	}
	
	public User loginDetails(String userName,String passWord)
	{
		User user= repository.findByUserNameAndPassWord(userName, passWord);
		if(user.getUserName()!=null&&user.getUserName()!="")
		{
			return user;
		}
		else
		{
			return null;
		}
		
	}
	
	}
