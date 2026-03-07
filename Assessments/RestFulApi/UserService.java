package com.cg.services;

import java.util.List;

import com.cg.entities.User;

public interface UserService {
	public User addUserDetails(User u);
	public List<User> getAllUsers();
	public User updateUser(int id,String name);
	public boolean deleteId(int id);
	
}
