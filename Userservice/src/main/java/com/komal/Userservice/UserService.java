package com.komal.Userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	//injection the UserRepository
	@Autowired
	private UserRepository userRepository ;
	
	// Retrieving all the records from the database
	public List<User> getAllUser()
	{
      return userRepository.findAll();
    }
	public User getUserById(Long id)
	{ 
		return userRepository.findById(id).orElse(null);
		
	}
	public User saveUser(User user)
	{ 
		return userRepository.save(user);
				
	}
	public User updateUser(Long id, User user)
	{
		// Fetches the existing user by ID
		User existingUser = userRepository.findById(id).orElse(null);
		// IF the USER exists, update its fields and save it
		if(existingUser  != null)
		{
			existingUser.setName(user.getName());
			existingUser.setPayementmode(user.getPayementmode());
			existingUser.setPrice(user.getPrice());
			return userRepository.save(existingUser);
			
		}
		return null;
		
	}
	
	public void deleteUser(Long id)
	{ userRepository.deleteById(id);
}
}