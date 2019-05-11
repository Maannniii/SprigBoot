package com.example.session.dbauth.customauth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Bcrypt extends BCryptPasswordEncoder implements PasswordEncoder {

	public Bcrypt() {
		super();
	}

	public Bcrypt(int a) {
		super(a);
	}

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		System.out.println("raw password encoder " + rawPassword);
		return super.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("Raw password " + rawPassword.toString());
		System.out.println("Encoded passwd " + encodedPassword);
		// TODO Auto-generated method stub
		return super.matches(rawPassword, encodedPassword);
	}

}
