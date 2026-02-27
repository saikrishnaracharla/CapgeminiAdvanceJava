package com.main.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
	@NotEmpty(message="name must not be empty")
	private String name;
	@Email(message="invalid email format")
	@NotEmpty(message="email cannot be empty")
	private String email;
	@Size(min=3,max=10,message="password must be between 3 to 10 chars")
	private String password;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
