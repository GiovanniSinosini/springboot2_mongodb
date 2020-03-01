package com.giosinosini.springboot2_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giosinosini.springboot2_mongodb.domain.Post;
import com.giosinosini.springboot2_mongodb.repository.PostRepository;
import com.giosinosini.springboot2_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired     // dependency injection - data access
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
