package com.qirara.currencyexchangeservice.controller;

import com.qirara.currencyexchangeservice.model.request.CurrencyExchange;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    private ResponseEntity<CurrencyExchange> retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = new CurrencyExchange(
                UUID.randomUUID().toString().replace("-", ""),
                from,
                to,
                BigDecimal.valueOf(15000)
        );

        String port = environment.getProperty("local.server.port");
        String service = environment.getProperty("spring.application.name");
        
        currencyExchange.setEnvironment(service.concat("-").concat(port));

        return ResponseEntity.ok(currencyExchange);
    }

}
