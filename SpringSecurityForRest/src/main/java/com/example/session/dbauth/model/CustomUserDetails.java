package com.example.session.dbauth.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Users implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomUserDetails() {
		super();
	}

	public CustomUserDetails(final Users users) {
		super(users);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return getRoles();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUser_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
