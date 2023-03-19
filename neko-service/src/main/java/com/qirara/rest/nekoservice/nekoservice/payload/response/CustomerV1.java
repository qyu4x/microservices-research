package com.qirara.rest.nekoservice.nekoservice.payload.response;

public class CustomerV1 {

    private String name;

    public CustomerV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
