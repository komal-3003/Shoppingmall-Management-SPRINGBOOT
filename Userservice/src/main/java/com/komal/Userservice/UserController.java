package com.komal.Userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	 
	@GetMapping("/user")
	public List<User> getAllRecords()
	{ 
		return userService.getAllUser();
					
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id)
	{
		return userService.getUserById(id);
		
	}
	
	@PostMapping("/user")
	public User createUser (@RequestBody User user)
	{
		 return userService.saveUser(user);
	}
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) 
	{
		return userService.updateUser(id, user);
		
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		userService.deleteUser(id);
	}
}
