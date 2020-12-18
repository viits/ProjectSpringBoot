package com.springboot.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
		
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Maria", "Maria@gmail.com", "12345678", "testando123");
		return ResponseEntity.ok().body(user);
	}


}
