package com.example.session.dbauth.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ua")
public class UnauthController {

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	HttpSession session;

	@GetMapping("/hello")
	public String unauthhello() {
		return "Hello world from UnAuth";
	}

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> map) {
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(
				map.get("username").toString(), map.get("password").toString()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		map.put("sessionid", session.getId());
		return map;
	}
}
