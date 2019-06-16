package com.example.session.dbauth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "user_data")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private String id;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String bu_id;
	private int band_id;
	private String grade;
	private int dept_id;
	private int desgn_id;
	private int company_id;
	private int location_id;
	private String status;
	private String type;
	private String isEnable;
	private String userupdated;
	private int moodleid;
	private String moodle_token;
	private java.util.Date lastloginTime;
	private String learningStyle;
	private java.util.Date created_at;
	private int invalidLoginCount;
	private int invalidLoginTimeStamp;
	private int lastlogoutTime;
	private int loginCount;
	private String flashScreen;
	private String profile_status;
	private int func_id;
	private int subfunc_id;
	private int region_id;
	private String password;

	protected Users(Users user) {
		this.id = user.id;
		this.firstname = user.firstname;
		this.lastname = user.lastname;
		this.phone = user.phone;
		this.email = user.email;
		this.bu_id = user.bu_id;
		this.band_id = user.band_id;
		this.grade = user.grade;
		this.dept_id = user.dept_id;
		this.desgn_id = user.desgn_id;
		this.company_id = user.company_id;
		this.location_id = user.location_id;
		this.status = user.status;
		this.type = user.type;
		this.isEnable = user.isEnable;
		this.userupdated = user.userupdated;
		this.moodleid = user.moodleid;
		this.moodle_token = user.moodle_token;
		this.lastloginTime = user.lastloginTime;
		this.learningStyle = user.learningStyle;
		this.created_at = user.created_at;
		this.invalidLoginCount = user.invalidLoginCount;
		this.invalidLoginTimeStamp = user.invalidLoginTimeStamp;
		this.lastlogoutTime = user.lastlogoutTime;
		this.loginCount = user.loginCount;
		this.flashScreen = user.flashScreen;
		this.profile_status = user.profile_status;
		this.func_id = user.func_id;
		this.subfunc_id = user.subfunc_id;
		this.region_id = user.region_id;
		this.password = user.password;
	}

	protected Users() {

	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getName() {
		return getFirstname() + " " + getLastname();
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getBu_id() {
		return bu_id;
	}

	public int getBand_id() {
		return band_id;
	}

	public String getGrade() {
		return grade;
	}

	public int getDept_id() {
		return dept_id;
	}

	public int getDesgn_id() {
		return desgn_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public String getIsenable() {
		return isEnable;
	}

	public String getUserupdated() {
		return userupdated;
	}

	public int getMoodleid() {
		return moodleid;
	}

	public String getMoodle_token() {
		return moodle_token;
	}

	public java.util.Date getLastlogintime() {
		return lastloginTime;
	}

	public String getLearningstyle() {
		return learningStyle;
	}

	public java.util.Date getCreated_at() {
		return created_at;
	}

	public int getInvalidlogincount() {
		return invalidLoginCount;
	}

	public int getInvalidlogintimestamp() {
		return invalidLoginTimeStamp;
	}

	public int getLastlogouttime() {
		return lastlogoutTime;
	}

	public int getLogincount() {
		return loginCount;
	}

	public String getFlashscreen() {
		return flashScreen;
	}

	protected String getProfile_status() {
		return profile_status;
	}

	public int getFunc_id() {
		return func_id;
	}

	public int getSubfunc_id() {
		return subfunc_id;
	}

	public int getRegion_id() {
		return region_id;
	}

	public String getPassword() {
		return password;
	}

	public String getUser_id() {
		return id;
	}

}
//@Entity
//@Table(name = "user_data")
//public class Users implements Serializable {
//	@Override
//	public String toString() {
//		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", lastName="
//				+ lastName + "]";
//	}
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUid = 1L;
//	@id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "user_id")
//	private String id;
//	@Column(name = "email")
//	private String email;
//	@Column(name = "password")
//	private String password;
//	@Column(name = "firstname")
//	private String name;
//	@Column(name = "lastname")
//	private String lastName;
//
//	public Users() {
//	}
//
//	public Users(Users user) {
//		id = user.id;
//		email = user.email;
//		password = user.password;
//		name = user.name;
//		lastName = user.lastName;
//	}
//
//	public String getid() {
//		return id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	
//
//	
//
//	
//
//	
//
//	
//
//	public Collection<? extends GrantedAuthority> getRoles() {
//		return new ArrayList<GrantedAuthority>(
//				Arrays.asList(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER")));
//	}
//}