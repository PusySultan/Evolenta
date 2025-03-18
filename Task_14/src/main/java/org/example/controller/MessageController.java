package org.example.controller;

import org.example.dto.Message;
import org.example.dto.Person;
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
    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(0,
                    "birthday",
                    "Come to my birthday party.",
                    LocalDateTime.now().minusHours(10)),

            new Message(1,
                    "auto",
                    "I bought a BMW M5 competition",
                    LocalDateTime.now().minusDays(2)),

            new Message(2,
                    "dog",
                    "Look at my dog.",
                    LocalDateTime.now().minusMinutes(30))
    ));

    @GetMapping("/message")
    public List<Message> getMessages()
    {
        return messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> getMessageById(@PathVariable int id) // Извлекаем id из адреса в переменную id
    {
       return messages.stream()
               .filter(message -> message.getId() == id)
               .findFirst();
    }

    @PostMapping("/message")
    public ResponseEntity<Message> addMessage(@RequestBody Message message)
    {
        int m_id = message.getId();

        for (Message m: messages)
        {
            if(m.getId() == m_id)
            {
                return new ResponseEntity<>(message, HttpStatus.CONFLICT);
            }
        }

        messages.add(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message)
    {
        for (Message m: messages)
        {
            if (id == m.getId())
            {
                messages.set(messages.indexOf(m), message);
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable int id)
    {
        if(messages.removeIf(message -> message.getId() == id))
        {
            return new ResponseEntity<>("Messege is deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error: message is not found", HttpStatus.CONFLICT);
    }
}
