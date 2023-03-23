package com.qirara.currencyconversionservice.proxy;

import com.qirara.currencyconversionservice.model.response.CurrencyConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @RequestMapping(method = RequestMethod.GET, path = "/currency-exchange/from/{from}/to/{to}", consumes = "application/json")
    ResponseEntity<CurrencyConversionResponse> retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to);

}
