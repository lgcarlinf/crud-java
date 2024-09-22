package com.hexagonal.practice.infrastructure.config;

import com.hexagonal.practice.application.service.PersonService;
import com.hexagonal.practice.application.usecase.PersonServiceImpl;
import com.hexagonal.practice.domain.ports.out.PersonOut;
import com.hexagonal.practice.infrastructure.repository.PersonJPARepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PersonService personService(PersonOut personOut) {
        return new PersonService(new PersonServiceImpl(personOut));
    }

    @Bean
    public PersonOut personOut(PersonJPARepositoryAdapter personJPARepositoryAdapter) {
        return personJPARepositoryAdapter;
    }
}
