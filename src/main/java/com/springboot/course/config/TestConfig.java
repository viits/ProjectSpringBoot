package com.springboot.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.course.entities.Order;
import com.springboot.course.entities.User;
import com.springboot.course.entities.enums.OrderStatus;
import com.springboot.course.repositories.OrderRepository;
import com.springboot.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "921212", "123456");
		
		Order order1 = new Order(null,Instant.parse("2020-06-20T19:53:07Z"),OrderStatus.PAID,user1);

		Order order2 = new Order(null,Instant.parse("2020-07-20T03:42:10Z"),OrderStatus.WAITING_PAYMENT,user2);

		Order order3 = new Order(null,Instant.parse("2020-07-20T15:21:22Z"),OrderStatus.WAITING_PAYMENT,user1);
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		orderRepository.saveAll(Arrays.asList(order1,order2,order3));
		
	}
	
}
