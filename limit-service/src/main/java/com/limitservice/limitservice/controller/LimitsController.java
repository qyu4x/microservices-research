package com.limitservice.limitservice.controller;

import com.limitservice.limitservice.configuration.ConfigurationProps;
import com.limitservice.limitservice.model.response.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final ConfigurationProps configurationProps;

    @Autowired
    public LimitsController(ConfigurationProps configurationProps) {
        this.configurationProps = configurationProps;
    }

    @GetMapping(path = "/limits")
    public Limits getLimits() {
        return new Limits(configurationProps.getMinimum(), configurationProps.getMaximum());
    }

}
