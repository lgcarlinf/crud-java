package com.hexagonal.practice.infrastructure.entity;

import com.hexagonal.practice.domain.model.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String gender;

    public PersonEntity() {
    }

    public PersonEntity(Long id, String name, String lastName, Date birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public static PersonEntity fromDomainModel(Person person){
        return new PersonEntity(person.getId(), person.getName(), person.getLastName(), person.getBirthDate(), person.getGender());
    }

    public Person toDomainModel(){
        return new Person(id, name, lastName, birthDate, gender);
    }
}
