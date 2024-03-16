package com.se4f7.prj301.entities;

import java.util.regex.Pattern;

public class User extends BaseEntity {
	private int id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	private String title;
	private int status;
	private String position;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User() {
	}

	public User(int id, String firstName, String lastName, String email, String password, String title, int status, String position) {
		this.id = id;
		this.firstName = firstName;
		this.password = password;
		this.lastName = lastName;
		this.email = email;
		this.title = title;
		this.status = status;
		this.position = position;

	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", password='" + password + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", title='" + title + '\'' +
				", status=" + status +
				", position='" + position + '\'' +
				'}';
	}
}
