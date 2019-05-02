package com.example.session.dbauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.session.dbauth.model.CustomUserDetails;
import com.example.session.dbauth.service.Userdata;

@RestController
@RequestMapping("/auth")
public class AuthController {

	// session scoped bean
	@Autowired
	Userdata user;

	@GetMapping("/hello")
	public String authhello(Authentication authentication) {
		System.out.println(user);
		CustomUserDetails customuser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		System.out.println(customuser);
		System.out.println(authentication.getPrincipal());
		return user.getEmail();
	}

	@GetMapping("/test")
	public String test() {
		return "Hello world from Auth";
	}

}
