package com.springboot.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.course.entities.User;
import com.springboot.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "921212", "123456");
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		
		
	}
	
}
