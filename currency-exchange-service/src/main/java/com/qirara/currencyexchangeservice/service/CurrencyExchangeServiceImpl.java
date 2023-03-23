package com.qirara.currencyexchangeservice.service;

import com.qirara.currencyexchangeservice.entity.CurrencyExchange;
import com.qirara.currencyexchangeservice.exception.DataNotFoundException;
import com.qirara.currencyexchangeservice.model.response.CurrencyExchangeResponse;
import com.qirara.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;


@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchangeResponse findByFromAndTo(String from, String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange == null)
            throw new DataNotFoundException(String.format("Currency conversion data from %s to %s not found", from, to));

        return new CurrencyExchangeResponse(
                currencyExchange.getId(),
                currencyExchange.getFrom(),
                currencyExchange.getTo(),
                currencyExchange.getCurrencyMultiple()
        );
    }
}
