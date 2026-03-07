package com.cg.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	private int id;
	@NotBlank(message="cannot b blank")
	@Size(min=4,max=30,message="must be in size")
	private String name;
	@NotBlank(message="email cannot be null")
	@Email(message="invalid email format")
	private String email;
	@NotBlank(message="this cannot be empty")
	private String city;
	public UserDto(String name2, String city2) {
		this.name=name2;
		this.city=city2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
