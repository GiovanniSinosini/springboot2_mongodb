package com.giosinosini.springboot2_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.giosinosini.springboot2_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {     // to access MongoDB data
	
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);    // spring data mount the query

}
