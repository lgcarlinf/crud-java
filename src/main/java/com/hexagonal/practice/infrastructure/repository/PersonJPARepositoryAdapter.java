package com.hexagonal.practice.infrastructure.repository;

import com.hexagonal.practice.domain.model.Person;
import com.hexagonal.practice.domain.ports.out.PersonOut;
import com.hexagonal.practice.infrastructure.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonJPARepositoryAdapter implements PersonOut {

    @Autowired
    private PersonJPARepository personJPARepository;

    @Override
    public Person createPerson(Person person) {
        PersonEntity personEntity = PersonEntity.fromDomainModel(person);
        return personJPARepository.save(personEntity).toDomainModel();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personJPARepository.findById(id).map(PersonEntity::toDomainModel);
    }

    @Override
    public Optional<Person> updatePerson(Long id, Person person) {
        if (personJPARepository.existsById(id)) {
           PersonEntity personEntity = PersonEntity.fromDomainModel(person);
           personEntity.setId(id);
           return Optional.of(personJPARepository.save(personEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deletePerson(Long id) {
        if (personJPARepository.existsById(id)) {
            personJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
