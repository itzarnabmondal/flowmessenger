package com.example.flowmessenger.repositories;

import com.example.flowmessenger.models.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Long> {
    // Check if a user with the given username already exists
    @Query("SELECT COUNT(*) > 0 FROM User WHERE username = :username")
    boolean existsByUsername(String username);
}