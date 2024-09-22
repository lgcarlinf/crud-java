package com.hexagonal.practice.domain.ports.in;

import com.hexagonal.practice.domain.model.Person;

import java.util.Optional;

public interface PersonIn {
    Person createPerson(Person person);
    Optional<Person> getPersonById(Long id);
    Optional<Person> updatePerson(Long id, Person person);
    boolean deletePerson(Long id);
}
