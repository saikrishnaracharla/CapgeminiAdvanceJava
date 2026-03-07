package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cg.entities.User;
import com.cg.repositories.RestRepository;
@Service
public class UserServiceImplements implements UserService {

    @Autowired
    RestRepository ur;
    @CachePut(value="users", key="#result.id")
    @Override
    public User addUserDetails(User u) {
        return ur.save(u);
    }
    @Cacheable(value="users", key="#id")
    public User getUserById(int id) {
        System.out.println("Fetching from database...");
        return ur.findById(id).orElse(null);
    }
    @Override
    public List<User> getAllUsers() {
        System.out.println("fetching all records");
        return ur.findAll();
    }
    @CachePut(value="users", key="#id")
    @Override
    public User updateUser(int id, String name) {
        Optional<User> updateEmp = ur.findById(id);

        if(updateEmp.isPresent()) {
            User emp = updateEmp.get();
            emp.setName(name);
            return ur.save(emp);
        }

        return null;
    }
    @CacheEvict(value="users", key="#id")
    @Override
    public boolean deleteId(int id) {
        if(ur.existsById(id)) {
            ur.deleteById(id);
            return true;
        }
        return false;
    }
}
