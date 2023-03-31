package com.qirara.currencyexchangeservice.controller;

import com.qirara.currencyexchangeservice.model.response.CurrencyExchangeResponse;
import com.qirara.currencyexchangeservice.model.response.WebResponse;
import com.qirara.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    private CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}", produces = "application/json")
    private ResponseEntity<CurrencyExchangeResponse> retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        String port = environment.getProperty("local.server.port");
        String service = environment.getProperty("spring.application.name");

        CurrencyExchangeResponse currencyExchangeResponse = currencyExchangeService.findByFromAndTo(from, to);
        currencyExchangeResponse.setEnvironment(service.concat("-").concat(port));


        return ResponseEntity.ok(currencyExchangeResponse);
    }

    @GetMapping(path = "/currency-exchange/hello")
    private String testHello() {
        return "Hello world";
    }

}
