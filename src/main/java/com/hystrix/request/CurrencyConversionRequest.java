package com.hystrix.request;

public class CurrencyConversionRequest {

    private int amount;
    private String currency;

    public CurrencyConversionRequest(){

    }

    public CurrencyConversionRequest(final int amount, final String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }
}
