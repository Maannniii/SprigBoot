package com.example.session.dbauth.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.session.dbauth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query(value = "select r from Role r where r.user_id=?1", nativeQuery = false)
	Set<Role> findByUserid(String userid);
	/*
	 * @Query(value = "select u from Users u where (u.email=?1 OR u.id=?1)",
	 * nativeQuery = false) Users findByName(String username);
	 */

}
