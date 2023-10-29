package com.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.entities.User;

public interface UserRepository extends MongoRepository<User, String>{

	//Custome Finder Method
	
	User findByUserId(String userId);
}
