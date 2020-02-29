package com.giosinosini.springboot2_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giosinosini.springboot2_mongodb.domain.User;
import com.giosinosini.springboot2_mongodb.dto.UserDTO;
import com.giosinosini.springboot2_mongodb.repository.UserRepository;
import com.giosinosini.springboot2_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired     // dependency injection - data access
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) { 
		User newObj = findById(obj.getId());     // get original object from the database
		updateData(newObj, obj);     /// copy new data to the newObj
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
