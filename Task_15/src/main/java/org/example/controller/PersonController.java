package org.example.controller;

import org.example.dto.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController
{
    @Autowired
    private PersonRepository repository;

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

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id)
    {
       repository.deleteById(id);

    }
}
