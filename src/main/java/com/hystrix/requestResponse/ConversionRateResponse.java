package com.hystrix.requestResponse;

public class ConversionRateResponse {

    private int rate;
    private String currency;

    public ConversionRateResponse(){

    }

    public String getCurrency() {
        return currency;
    }

    public int getRate() {
        return rate;
    }
}
