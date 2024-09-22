package com.hexagonal.practice.infrastructure.repository;

import com.hexagonal.practice.infrastructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJPARepository extends JpaRepository<PersonEntity, Long> {
}
