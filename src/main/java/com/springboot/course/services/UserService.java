package com.springboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.course.entities.User;
import com.springboot.course.repositories.UserRepository;
import com.springboot.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id,User user) {
		User entity =  userRepository.getOne(id);
		updateData(entity,user);
		return userRepository.save(entity);
	}
	private void updateData(User entity,User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
	
}
