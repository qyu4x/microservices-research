package com.qirara.rest.nekoservice.nekoservice.payload.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponse {

    public UserResponse(String id, String name, LocalDate birthDate, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private String id;

    private String name;

    private LocalDate birthDate;

    private LocalDateTime createdAt;

}
