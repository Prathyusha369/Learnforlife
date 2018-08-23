package com.springmvchibernate.entity;

public class Registration {

	String userName;
	String password;
	String email;
	String role;
	String gender;

	public Registration(String userName, String password, String email, String role, String gender) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.gender = gender;
	}

	public Registration() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", gender=" + gender + "]";
	}

}
