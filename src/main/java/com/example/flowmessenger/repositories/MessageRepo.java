package com.example.flowmessenger.repositories;

import com.example.flowmessenger.models.Message;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepo extends ListCrudRepository<Message, Long> {
}