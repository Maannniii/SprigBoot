package com.example.session.dbauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.session.dbauth.model.CustomUserDetails;
import com.example.session.dbauth.model.Users;
import com.example.session.dbauth.repository.RoleRepository;
import com.example.session.dbauth.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RoleRepository rolerepo;

	@Autowired
	Userdata user;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepository.findByName(username);
		CustomUserDetails CustomUser = new CustomUserDetails(users, rolerepo.findByUserid(users.getUser_id()));
		user.setUser(CustomUser);
		return CustomUser;
	}

}
