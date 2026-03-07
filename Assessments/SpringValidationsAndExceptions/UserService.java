package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.User;
import com.cg.respositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository ur;
	
	public User saveUser(User user) {
		return ur.save(user);	
	}
	public List<User> getAllInfo(){
		return ur.findAll();
	}
	public User getUser(int id) {
		return ur.findById(id).orElseThrow(()->new RuntimeException("invlaid id "+id));
	}
	public User updateUser(int id, User user) {
	    User existingUser = ur.findById(id).orElseThrow(() -> new RuntimeException("invalid user " + id));
	    existingUser.setName(user.getName());
//	    existingUser.setEmail(user.getEmail());
//	    existingUser.setCity(user.getCity());
	    return ur.save(existingUser);
	}
	public void deleteUser(int id) {
		User avalibleUser=ur.findById(id).orElseThrow(()->new RuntimeException("invalid user "+id));
		ur.delete(avalibleUser);
		
	}
}
