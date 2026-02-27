package com.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate; // Fixed import
import org.springframework.stereotype.Repository;
import com.main.model.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate; // Fixed type

    public int saveUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        // Use jdbcTemplate.update, NOT JndiTemplate
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());
    }
}
