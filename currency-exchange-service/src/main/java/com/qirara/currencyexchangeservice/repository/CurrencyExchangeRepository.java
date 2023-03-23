package com.qirara.currencyexchangeservice.repository;

import com.qirara.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, String> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
