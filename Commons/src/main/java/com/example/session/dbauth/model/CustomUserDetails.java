package com.example.session.dbauth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Users implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomUserDetails() {
		super();
	}

	public CustomUserDetails(final Users users, Set<Role> roles) {
		super(users);
		setAuthorities(roles);
	}

	/*******************************************************************************/
	private Collection<GrantedAuthority> authorities;
	private Set<String> stakeholderLevel = new HashSet<String>();
	private Set<String> coachLevel = new HashSet<String>();
	private Set<String> curatorLevel = new HashSet<String>();
//	private boolean isCorporateStakeholder;
//	private boolean isCompanyStakeholder;
//	private boolean isBuStakeholder;
//	private boolean isCorporateCoach;
//	private boolean isCorporateCurator;

	public void setAuthorities(Set<Role> roles) {
		authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			String role_level = "";
			switch (role.getRole_level_id()) {
			case 1:
				role_level = "corporate";
				break;
			case 2:
				role_level = "company";
				break;
			case 3:
				role_level = "businessunit";
				break;
			case 4:
				role_level = "team";
				break;
			}
			switch (role.getPrivilege_id()) {
			case 1:
				authorities.add(new SimpleGrantedAuthority("ROLE_STAKEHOLDER"));
				stakeholderLevel.add(role_level);
				break;
			case 2:
				authorities.add(new SimpleGrantedAuthority("ROLE_SME"));
				coachLevel.add(role_level);
				break;
			case 3:
				authorities.add(new SimpleGrantedAuthority("ROLE_CURATOR"));
				curatorLevel.add(role_level);
				break;
			}
		}
	}

	public Set<String> getStakeholderLevels() {
		return stakeholderLevel;
	}

	public Set<String> getCoachLevels() {
		return coachLevel;
	}

	public Set<String> getCuratorLevels() {
		return curatorLevel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/*******************************************************************************/

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
