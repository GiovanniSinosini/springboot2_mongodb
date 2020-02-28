package com.giosinosini.springboot2_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giosinosini.springboot2_mongodb.domain.User;
import com.giosinosini.springboot2_mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired     // dependency injection - data access
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
