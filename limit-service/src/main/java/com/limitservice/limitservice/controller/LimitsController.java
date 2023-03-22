package com.limitservice.limitservice.controller;

import com.limitservice.limitservice.model.response.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @GetMapping(path = "/limits")
    public Limits getLimits() {
        return new Limits(1, 1000);
    }

}
