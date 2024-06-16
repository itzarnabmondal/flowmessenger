package com.example.flowmessenger.repositories;

import com.example.flowmessenger.models.Attachment;
import org.springframework.data.repository.ListCrudRepository;

public interface AttachmentRepo extends ListCrudRepository<Attachment, Long> {
}