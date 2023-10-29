 package com.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entities.User;
import com.user.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
		
	}
	
	//get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
	
	//get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	
	//delete user by id
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUserById(@PathVariable String userId){
		try {
			userService.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserById(@PathVariable String userId, @RequestBody User user) {
	    try {
	        User updatedUser = userService.update(user,userId);
	        if (updatedUser != null) {
	            return ResponseEntity.ok(updatedUser);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	

}
