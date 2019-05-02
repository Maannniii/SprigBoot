package com.example.session.dbauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ua")
public class UnauthController {

	@GetMapping("/hello")
	public String unauthhello() {
		return "Hello world from UnAuth";
	}
}
