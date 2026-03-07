package com.cg.controllers;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dto.UserDto;
import com.cg.entities.User;
import com.cg.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class MyController {
	@Autowired
	UserService us;
	
	@PostMapping
	public Object addUser(@Valid @RequestBody UserDto dto,org.springframework.validation.BindingResult result) {
	    if (result.hasErrors()) {
	        return result.getFieldError().getDefaultMessage();
	    }
	    User user = new User();
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setCity(dto.getCity());

	    return us.saveUser(user);
	}
	@GetMapping
	public List<UserDto> getAllIfo(){
	    List<User> users = us.getAllInfo();
	    return users.stream().map(user -> new UserDto(user.getName(),user.getCity())).toList();
	}
	@GetMapping("/{id}")
	public User finById(@PathVariable int id) {
		return us.getUser(id);
	}
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id,@Valid @RequestBody UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setCity(dto.getCity());
        return us.updateUser(id, user);
		
	}
	@DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        us.deleteUser(id);
        return "User deleted successfully";
    }
	

}
