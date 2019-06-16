package com.example.session.dbauth.service;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.example.session.dbauth.model.CustomUserDetails;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Userdata implements Serializable {

	private static final long serialVersionUID = 1L;
	private CustomUserDetails user;

	public void setUser(CustomUserDetails user) {
		this.user = user;
	}

	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String toString() {
		return user.toString();
	}
}
