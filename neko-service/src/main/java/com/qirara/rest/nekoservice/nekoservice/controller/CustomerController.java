package com.qirara.rest.nekoservice.nekoservice.controller;

// this is best practice for versioning API

import com.qirara.rest.nekoservice.nekoservice.payload.response.CustomerV1;
import com.qirara.rest.nekoservice.nekoservice.payload.response.CustomerV2;
import com.qirara.rest.nekoservice.nekoservice.payload.response.Name;
import com.qirara.rest.nekoservice.nekoservice.payload.response.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/")
public class CustomerController {

    // sample version 1
    @GetMapping(path = "/v1/customer")
    public ResponseEntity<WebResponse<CustomerV1>> getFirstVersionCustomer() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new CustomerV1("Kaguya shinomiya")
                ));
    }

    // sample to migrate to version 2 but not change available version 1 , just change the url (Twotter usw this approach to versioning API)
    @GetMapping(path = "/v2/customer")
    public ResponseEntity<WebResponse<CustomerV2>> getSecondVersionCustomer() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new CustomerV2(
                                new Name("Kaguya", "Shonomiya")
                        )
                ));
    }

    // sample with request param (amazon use this approach)
    @GetMapping(path = "/customer/", params = "version=1")
    public ResponseEntity<WebResponse<CustomerV1>> getFirstVersionCustomeRequestParam() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new CustomerV1("Kaguya shinomiya")
                ));
    }

    @GetMapping(path = "/v2/customer", params = "version=2")
    public ResponseEntity<WebResponse<CustomerV2>> getSecondVersionCustomerRequestParam() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new CustomerV2(
                                new Name("Kaguya", "Shonomiya")
                        )
                ));
    }

    // sample with request param (microsoft use this approach)
    @GetMapping(path = "/customer/", headers = "X-API-VERSION=1")
    public ResponseEntity<WebResponse<CustomerV1>> getFirstVersionCustomeRequestHeader() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new CustomerV1("Kaguya shinomiya")
                ));
    }

    @GetMapping(path = "/v2/customer",  headers = "X-API-VERSION=2")
    public ResponseEntity<WebResponse<CustomerV2>> getSecondVersionCustomerRequestHeader() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new CustomerV2(
                                new Name("Kaguya", "Shonomiya")
                        )
                ));
    }

    // 4. is based on media types (github use this approach)


}
