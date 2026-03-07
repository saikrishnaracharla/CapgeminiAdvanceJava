package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.User;
import com.cg.repositories.RestRepository;

@Service
public class UserServiceImplements implements UserService{

		@Autowired
		RestRepository ur;
	@Override
	public User addUserDetails(User u) {
		return ur.save(u);
	}
	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}
	@Override
	public User updateUser(int id, String name) {
		Optional<User> updateEmp=ur.findById(id);
		if(updateEmp.isPresent()) {
			User emp=updateEmp.get();
			emp.setName(name);
			return ur.save(emp);
		}
		
		return null;
	}
	@Override
	public boolean deleteId(int id) {
		if(ur.existsById(id)) {
			ur.deleteById(id);
			return true;
		}
		return false;
	}

}
