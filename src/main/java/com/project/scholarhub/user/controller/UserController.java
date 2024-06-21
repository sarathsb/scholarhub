package com.project.scholarhub.user.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.scholarhub.user.model.User;
import com.project.scholarhub.user.service.UserService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	UserService service; 
	
	@PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception
    {
		
	  return service.registerUser(user);
	  
    }

	@GetMapping
	public List<User> listUser()
	{
		return service.listUser();
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable UUID id)
	{
		return service.deleteUser(id);
		
	}
	
	@GetMapping("/{id}")
    public User listUser(@PathVariable UUID id)
    {
		
		return service.listUser(id);
    }
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable UUID id,@RequestBody User user)
	{
		return service.updateUser(id,user);
	}
	
	@GetMapping("/login")
	public User loginDetails(@RequestParam String userName,@RequestParam String passWord)
	{
		return service.loginDetails(userName,passWord);
	}
	

}
