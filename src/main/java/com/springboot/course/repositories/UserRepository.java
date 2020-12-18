package com.springboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 
}
