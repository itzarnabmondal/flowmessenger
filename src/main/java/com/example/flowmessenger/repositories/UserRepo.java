package com.example.flowmessenger.repositories;

import com.example.flowmessenger.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Long> {
}