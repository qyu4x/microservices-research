package com.qirara.currencyconversionservice.controller;

import com.qirara.currencyconversionservice.model.response.CurrencyConversionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionResponse> retrieveConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("from", from);
        uriVariable.put("to", to);

        String URI = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
        ResponseEntity<CurrencyConversionResponse> currencyConversionResponse = new RestTemplate().getForEntity(URI, CurrencyConversionResponse.class, uriVariable);
        CurrencyConversionResponse currencyConversion = currencyConversionResponse.getBody();
       
        return ResponseEntity.ok(new CurrencyConversionResponse(
                currencyConversion.getId(),
                from,
                to,
                quantity,
                currencyConversion.getCurrencyMultiple(),
                quantity.multiply(currencyConversion.getCurrencyMultiple()),
                currencyConversion.getEnvironment()
        ));
    }

}
