package com.qirara.rest.nekoservice.nekoservice.payload.response;

public class CustomerV2 {

    private Name name;

    public CustomerV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
