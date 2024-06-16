package com.example.flowmessenger.repositories;

import com.example.flowmessenger.models.Conversation;
import org.springframework.data.repository.ListCrudRepository;

public interface ConversationRepo extends ListCrudRepository<Conversation, Long> {
}