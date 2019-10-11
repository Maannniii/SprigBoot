package com.example.session.dbauth.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.session.dbauth.model.CustomUserDetails;
import com.example.session.dbauth.model.Users;
import com.example.session.dbauth.repository.RoleRepository;
import com.example.session.dbauth.repository.UsersRepository;

@Service
@Primary
public class CustomUserDetailsService extends Userdata implements Serializable, UserDetailsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RoleRepository rolerepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepository.findByName(username);
		return initUser(new CustomUserDetails(users, rolerepo.findByUserid(users.getUser_id())));
	}

}
