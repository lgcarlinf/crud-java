package com.hexagonal.practice.application.service;

import com.hexagonal.practice.domain.model.Person;
import com.hexagonal.practice.domain.ports.in.PersonIn;

import java.util.Optional;

public class PersonService implements PersonIn {

    private final PersonIn personaIn;

    public PersonService(PersonIn personaIn) {
        this.personaIn = personaIn;
    }


    @Override
    public Person createPerson(Person person) {
        return personaIn.createPerson(person);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personaIn.getPersonById(id);
    }

    @Override
    public Optional<Person> updatePerson(Long id, Person person) {
        return personaIn.updatePerson(id, person);
    }

    @Override
    public boolean deletePerson(Long id) {
        return personaIn.deletePerson(id);
    }

}
