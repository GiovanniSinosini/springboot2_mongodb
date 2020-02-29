package com.giosinosini.springboot2_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.giosinosini.springboot2_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {     // to access MongoDB data
	
	

}
