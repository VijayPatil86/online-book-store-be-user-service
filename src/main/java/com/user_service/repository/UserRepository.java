package com.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserEmail(String email);
}
