package com.hexagonal.practice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Person {
    private Long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String gender;

    public Person(Long id, String name, String lastName, Date birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
