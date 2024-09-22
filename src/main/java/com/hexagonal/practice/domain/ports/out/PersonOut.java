package com.hexagonal.practice.domain.ports.out;

import com.hexagonal.practice.domain.model.Person;

import java.util.Optional;

public interface PersonOut {
    Person createPerson(Person persona);
    Optional<Person> getPersonById(Long id);
    Optional<Person> updatePerson(Long id, Person person);
    boolean deletePerson(Long id);
}
