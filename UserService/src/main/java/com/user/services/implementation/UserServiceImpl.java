package com.user.services.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entities.User;
import com.user.repository.UserRepository;
import com.user.services.UserService;
import com.user.services.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		//String randomeUserId = UUID.randomUUID().toString();
		//user.setUserId(randomeUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User With Given Id Is Not Found On Server !!!!" + userId));
	}

	@Override
	public User update(User user, String userId) {
			    
		user.setUserId(userId);
	    
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	
}
