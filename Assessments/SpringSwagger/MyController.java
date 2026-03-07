package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.User;
import com.cg.services.UserService;

@RestController
public class MyController {
	@Autowired
	UserService us;
	@PostMapping("/user")
	public User displayUser(@RequestBody User user) {
		
		return us.addUserDetails(user);
		
	}
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return us.getAllUsers();
	}
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
	    return us.updateUser(id,user.getName());
	}
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
	    boolean status = us.deleteId(id);

	    if (status) {
	        return "User deleted successfully";
	    } else {
	        return "User not found";
	    }
	}


}

