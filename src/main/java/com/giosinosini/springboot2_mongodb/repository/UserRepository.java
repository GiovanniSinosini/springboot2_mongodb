package com.giosinosini.springboot2_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.giosinosini.springboot2_mongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {     // to access MongoDB data
	
	

}
