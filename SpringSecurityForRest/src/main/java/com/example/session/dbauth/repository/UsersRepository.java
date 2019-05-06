package com.example.session.dbauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.session.dbauth.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query(value = "select u from Users u where (u.email=?1 OR u.id=?1)", nativeQuery = false)
	Users findByName(String username);
}
