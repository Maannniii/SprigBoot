package com.example.session.dbauth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

class RoleIds implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String user_id;
	int privilege_id;
	int role_level_id;
}

@Entity
@IdClass(RoleIds.class)
@Table(name = "privilege_scope")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String user_id;
	@Id
	private int privilege_id;
	@Id
	private int role_level_id;

	protected Role() {
	}

	public Role(String user_id, int privilege_id, int role_level_id) {
		this.user_id = user_id;
		this.privilege_id = privilege_id;
		this.role_level_id = role_level_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPrivilege_id() {
		return privilege_id;
	}

	public void setPrivilege_id(int privilege_id) {
		this.privilege_id = privilege_id;
	}

	public int getRole_level_id() {
		return role_level_id;
	}

	public void setRole_level_id(int role_level_id) {
		this.role_level_id = role_level_id;
	}

	@Override
	public String toString() {
		return "Role [user_id=" + user_id + ", privilege_id=" + privilege_id + ", role_level_id=" + role_level_id + "]";
	}
}
