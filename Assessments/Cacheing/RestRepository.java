package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.User;

public interface RestRepository extends JpaRepository<User,Integer> {

}

