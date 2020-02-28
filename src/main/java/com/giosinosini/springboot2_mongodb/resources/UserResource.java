package com.giosinosini.springboot2_mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giosinosini.springboot2_mongodb.domain.User;
import com.giosinosini.springboot2_mongodb.dto.UserDTO;
import com.giosinosini.springboot2_mongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {   //back-end

	@Autowired
	private UserService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){             // ResponseEntity = encapsulate http responses
		List<User> list = service.findAll();    // searches for users in the database 
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());   // convert each list item into DTO object
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
