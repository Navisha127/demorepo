package com.nagarro.advancejava.assignment4.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
public class User {

	@Id @GeneratedValue
	private int userId;
	
	@Column(unique=true)
	@NotEmpty
	private String userName ;
	
	@Pattern(regexp = "^(.+)@(.+)",message="should be valid")
	private String email ;
	
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	private String password ;
	
	public int getUserId() {
		return userId;
	}
	
	public void setId(int id) {
		this.userId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String name) {
		this.fullName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", userName=" + userName + ", email=" + email + ", name=" + fullName + ", pass=" + password + "]";
	}
	
}
