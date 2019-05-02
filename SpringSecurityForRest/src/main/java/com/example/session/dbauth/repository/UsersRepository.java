package com.example.session.dbauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.session.dbauth.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByName(String username);
}
