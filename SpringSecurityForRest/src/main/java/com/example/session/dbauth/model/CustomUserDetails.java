package com.example.session.dbauth.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Users implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomUserDetails() {

	}

	public CustomUserDetails(final Users users) {
		super(users);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getName();
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
	public String toString() {
		return "CustomUserDetails [getAuthorities()=" + getAuthorities() + ", getPassword()=" + getPassword()
				+ ", getUsername()=" + getUsername() + ", isAccountNonExpired()=" + isAccountNonExpired()
				+ ", isAccountNonLocked()=" + isAccountNonLocked() + ", isCredentialsNonExpired()="
				+ isCredentialsNonExpired() + ", isEnabled()=" + isEnabled() + ", getId()=" + getId() + ", getEmail()="
				+ getEmail() + ", getName()=" + getName() + ", getLastName()=" + getLastName() + ", getActive()="
				+ getActive() + ", getRoles()=" + getRoles() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
