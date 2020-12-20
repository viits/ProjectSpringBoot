package com.springboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
