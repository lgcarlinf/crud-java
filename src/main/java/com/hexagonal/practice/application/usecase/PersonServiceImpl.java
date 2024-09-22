package com.hexagonal.practice.application.usecase;

import com.hexagonal.practice.domain.model.Person;
import com.hexagonal.practice.domain.ports.in.PersonIn;
import com.hexagonal.practice.domain.ports.out.PersonOut;

import java.util.Optional;

public class PersonServiceImpl implements PersonIn {

        private final PersonOut personOut;

        public PersonServiceImpl(PersonOut personOut) {
            this.personOut = personOut;
        }

        @Override
        public Person createPerson(Person person) {
            return personOut.createPerson(person);
        }

        @Override
        public Optional<Person> getPersonById(Long id) {
            return personOut.getPersonById(id);
        }

        @Override
        public Optional<Person> updatePerson(Long id, Person person) {
            return personOut.updatePerson(id, person);
        }

        @Override
        public boolean deletePerson(Long id) {
            return personOut.deletePerson(id);
        }
}
