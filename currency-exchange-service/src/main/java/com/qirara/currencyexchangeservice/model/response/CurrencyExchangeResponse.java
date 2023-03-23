package com.qirara.currencyexchangeservice.model.response;

import java.math.BigDecimal;

public class CurrencyExchangeResponse {

    private String id;

    private String from;

    private String to;

    private BigDecimal currencyMultiple;

    private String environment;

    public CurrencyExchangeResponse() {
    }

    public CurrencyExchangeResponse(String id, String from, String to, BigDecimal currencyMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.currencyMultiple = currencyMultiple;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getCurrencyMultiple() {
        return currencyMultiple;
    }

    public void setCurrencyMultiple(BigDecimal currencyMultiple) {
        this.currencyMultiple = currencyMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
