package com.example.session.dbauth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.session.dbauth.service.Userdata;

@RestController
@RequestMapping("/auth")
public class AuthController {

	// session scoped bean
	@Autowired
	Userdata user;

	@Autowired
	HttpSession session;

	@GetMapping("/hello")
	public String authhello(Authentication authentication) {
		return user.getEmail();
	}

	@GetMapping("/test")
	public String test() {
		return "Hello world from Auth";
	}

	@PostMapping("/logout")
	public Map<String, Object> logout() {
		Map<String, Object> response = new HashMap<String, Object>();
		session.getId();
		if (!session.isNew()) {
			session.invalidate();
			SecurityContextHolder.getContext().setAuthentication(null);
			response.put("status", "success");
			response.put("response", "Session invalidated");
		} else {
			response.put("status", "failed");
			response.put("response", "No such session exists");
		}
		return response;
	}

}
