package com.qirara.currencyexchangeservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private String id;

    @Column(name = "currency_exchange_from")
    private String from;

    @Column(name = "currency_exchange_to")
    private String to;

    private BigDecimal currencyMultiple;

    public CurrencyExchange() {
    }

    public CurrencyExchange(String id, String from, String to, BigDecimal currencyMultiple) {
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
}
