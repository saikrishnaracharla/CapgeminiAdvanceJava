package com.cg.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
