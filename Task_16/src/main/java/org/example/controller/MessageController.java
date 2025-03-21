package org.example.controller;

import org.example.dto.Message;
import org.example.dto.Person;
import org.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController
{
    @Autowired
    private MessageRepository repository;

    @GetMapping("/message")
    public Iterable<Message> getMessages()
    {
        return repository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> getMessageById(@PathVariable int id) // Извлекаем id из адреса в переменную id
    {
      return repository.findById(id);
    }

    @PostMapping("/message")
    public ResponseEntity<Message> addMessage(@RequestBody Message message)
    {
        System.out.println(message);
        repository.save(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message)
    {
        if(repository.existsById(id))
        {
            message.setId(id);
            return new ResponseEntity<>(repository.save(message), HttpStatus.OK);
        }

        return new ResponseEntity<>(repository.save(message), HttpStatus.CREATED);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id)
    {
        repository.deleteById(id);
    }

    @DeleteMapping("/message")
    public void deleteMessages()
    {
        repository.deleteAll();
    }
}
