package com.qirara.currencyexchangeservice.service;

import com.qirara.currencyexchangeservice.model.response.CurrencyExchangeResponse;

public interface CurrencyExchangeService {
    CurrencyExchangeResponse findByFromAndTo(String from, String to);
}
