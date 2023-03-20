package com.qirara.rest.nekoservice.nekoservice.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(value = "password") // this is use like jsonIgnore but can use in multiple  field, prefer use jsonIgnore approach
public class MerchantResponse {

    @JsonProperty(value = "full_name")
    private String fullName;

    private String email;

    @JsonIgnore // this is will be ingnore field password in response entity, this is called static filtering
    private String password;

    public MerchantResponse(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
