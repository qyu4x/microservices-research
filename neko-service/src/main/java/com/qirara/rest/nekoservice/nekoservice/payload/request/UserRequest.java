package com.qirara.rest.nekoservice.nekoservice.payload.request;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserRequest {

    public UserRequest(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;

    @Past(message = "Date of birth must be a past date")
    private LocalDate birthDate;


}
