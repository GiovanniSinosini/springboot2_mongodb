package com.giosinosini.springboot2_mongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.giosinosini.springboot2_mongodb.domain.Post;
import com.giosinosini.springboot2_mongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {   //back-end

	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){           
		Post obj = service.findById(id);   
		return ResponseEntity.ok().body(obj);
	}
}
