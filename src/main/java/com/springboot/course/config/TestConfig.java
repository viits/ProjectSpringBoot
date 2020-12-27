package com.springboot.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.course.entities.Category;
import com.springboot.course.entities.Order;
import com.springboot.course.entities.OrderItem;
import com.springboot.course.entities.Payment;
import com.springboot.course.entities.Product;
import com.springboot.course.entities.User;
import com.springboot.course.entities.enums.OrderStatus;
import com.springboot.course.repositories.CategoryRepository;
import com.springboot.course.repositories.OrderItemRepository;
import com.springboot.course.repositories.OrderRepository;
import com.springboot.course.repositories.ProductRepository;
import com.springboot.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "921212", "123456");
		
		Order order1 = new Order(null,Instant.parse("2020-06-20T19:53:07Z"),OrderStatus.PAID,user1);
		Order order2 = new Order(null,Instant.parse("2020-07-20T03:42:10Z"),OrderStatus.WAITING_PAYMENT,user2);
		Order order3 = new Order(null,Instant.parse("2020-07-20T15:21:22Z"),OrderStatus.WAITING_PAYMENT,user1);
		
		Category category1 = new Category(null,"Eletronics");
		Category category2 = new Category(null,"Books");
		Category category3 = new Category(null,"Computers");
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		orderRepository.saveAll(Arrays.asList(order1,order2,order3));
		categoryRepository.saveAll(Arrays.asList(category1,category2,category3));
		productRepository.saveAll(Arrays.asList(product1,product2,product3,product4,product5));
		
		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product2.getCategories().add(category3);
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(product1,product2,product3,product4,product5));
		
		OrderItem orderItem1 = new OrderItem(order1,product1,2,product1.getPrice());
		OrderItem orderItem2 = new OrderItem(order1,product3,1,product4.getPrice());
		OrderItem orderItem3 = new OrderItem(order2,product5,2,product1.getPrice());
		OrderItem orderItem4 = new OrderItem(order3,product5,2,product5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2,orderItem3,orderItem4));
		
		Payment pay1 = new Payment(null,Instant.parse("2020-06-20T21:00:07Z"),order1);
		order1.setPayment(pay1);
		orderRepository.save(order1);
	}
	
}
