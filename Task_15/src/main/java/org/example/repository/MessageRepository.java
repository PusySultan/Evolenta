package org.example.repository;

import org.example.dto.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer>
{
}
