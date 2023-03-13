package com.qirara.rest.nekoservice.nekoservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    private LocalDate birthDate;

    private LocalDateTime createdAt;

}
