package com.springboot.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.course.entities.Order;
import com.springboot.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderServices;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok().body(this.orderServices.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = this.orderServices.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
