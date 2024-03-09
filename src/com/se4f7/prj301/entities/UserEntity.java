package com.se4f7.prj301.entities;

import java.util.regex.Pattern;

public class UserEntity extends BaseEntity {

	private String username;
	private String lastName;
	private String firstName;
	private String password;
	private int status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username == null || username.length() < 6 || username.length() > 50) {
			throw new IllegalArgumentException("Username is required and must have a length from 6 to 50 characters.");
		}
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name is required.");
		}
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name is required.");
		}
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.length() < 13 || password.length() > 50) {
			throw new IllegalArgumentException("Password is required and must have a length from 13 to 50 characters.");
		}
		if (!Pattern.compile("[A-Z]").matcher(password).find()) {
			throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
		}
		if (!Pattern.compile("[a-z]").matcher(password).find()) {
			throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
		}
		if (!Pattern.compile("[0-9]").matcher(password).find()) {
			throw new IllegalArgumentException("Password must contain at least one digit.");
		}
		if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
			throw new IllegalArgumentException("Password must contain at least one special symbol.");
		}
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if (status != 0 && status != 1) {
			throw new IllegalArgumentException("Invalid status value. Status must be either 0 or 1.");
		}
		this.status = status;
	}
}