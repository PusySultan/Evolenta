package org.example.controller;

import jakarta.transaction.Transactional;
import org.example.AppService;
import org.example.dto.Message;
import org.example.dto.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController
{
    @Autowired
    private PersonRepository repository;

    @Autowired
    private AppService appService;

    @GetMapping
    public String hello()
    {
        return "Hello, World!";
    }

    @GetMapping("/person")
    public  Iterable<Person> getPersons()
    {
        return repository.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id)
    {
        return repository.findById(id);
    }

    @GetMapping("/person/{id}/message")
    public ResponseEntity<List<Message>> getMessages(@PathVariable int id)
    {
       return appService.getPersonMessagesById(id);
    }

    @GetMapping("/person/{person_id}/message/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int person_id, @PathVariable int message_id)
    {
        return appService.getPersonMessageById(person_id, message_id);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) // @RequestBody Person - JSON to Person
    {
        if(repository.existsById(id))
        {
            person.setId(id);
            return new ResponseEntity<>(repository.save(person), HttpStatus.OK);
        }

        return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) // @RequestBody Person - JSON to Person
    {
        return repository.save(person);
    }

    @PostMapping("/person/{id}/message")
    public ResponseEntity<Person> addMessage(@PathVariable int id, @RequestBody Message message)
    {
        return appService.addMeesageToPerson(id, message);
    }

    @DeleteMapping("/person/{id}/message")
    public ResponseEntity<Person> deleteMessages(@PathVariable int id)
    {
        return appService.deleteMeesagesToPerson(id);
    }

    @DeleteMapping("/person/{person_id}/message/{message_id}")
    @Transactional
    public ResponseEntity<Person> deleteMessage(@PathVariable int person_id, @PathVariable int message_id)
    {
        return appService.deleteMessageToPerson(person_id, message_id);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id)
    {
       repository.deleteById(id);
    }

    @DeleteMapping("/person")
    public void deletePersons()
    {
        repository.deleteAll();

    }
}
