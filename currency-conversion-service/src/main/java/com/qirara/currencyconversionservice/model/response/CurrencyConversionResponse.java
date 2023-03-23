package com.qirara.currencyconversionservice.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyConversionResponse {
    private String id;

    private String from;

    private String to;

    private BigDecimal quantity;

    private BigDecimal currencyMultiple;

    private BigDecimal currencyConversion;

    private String environment;

    public CurrencyConversionResponse() {
    }

    public CurrencyConversionResponse(String id, String from, String to, BigDecimal quantity, BigDecimal currencyMultiple, BigDecimal currencyConversion, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.currencyMultiple = currencyMultiple;
        this.currencyConversion = currencyConversion;
        this.environment = environment;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCurrencyMultiple() {
        return currencyMultiple;
    }

    public void setCurrencyMultiple(BigDecimal currencyMultiple) {
        this.currencyMultiple = currencyMultiple;
    }

    public BigDecimal getCurrencyConversion() {
        return currencyConversion;
    }

    public void setCurrencyConversion(BigDecimal currencyConversion) {
        this.currencyConversion = currencyConversion;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
