package com.hexagonal.practice.infrastructure.controller;

import com.hexagonal.practice.application.service.PersonService;
import com.hexagonal.practice.domain.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
public class PersonaController {
    private final PersonService personService;

    public PersonaController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person createPerson = personService.createPerson(person);
        return new ResponseEntity<>(createPerson , HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person)
                .map(personMap -> new ResponseEntity<>(personMap, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id) ? new ResponseEntity<>(HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
