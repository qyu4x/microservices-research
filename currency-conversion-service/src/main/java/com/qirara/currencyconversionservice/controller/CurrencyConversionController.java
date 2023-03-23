package com.qirara.currencyconversionservice.controller;

import com.qirara.currencyconversionservice.model.response.CurrencyConversionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionResponse> retrieveConversion(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
        return ResponseEntity.ok(new CurrencyConversionResponse(
                "aW5pIGFkYWxhbGFoIGlkIGtlIHNhdHU=",
                from,
                to,
                quantity,
                BigDecimal.ONE,
                BigDecimal.TEN,
                ""
        ));
    }

}
