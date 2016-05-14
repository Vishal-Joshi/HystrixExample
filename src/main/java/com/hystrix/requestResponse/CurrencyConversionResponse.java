package com.hystrix.requestResponse;

public class CurrencyConversionResponse {
    private int convertedAmountInINR;
    private String currencyConversionFrom;
    private int initalAmountSubmitted;

    public CurrencyConversionResponse() {

    }

    public CurrencyConversionResponse(int convertedAmountInINR, String currencyConversionFrom, int nonConvertedmount) {
        this.convertedAmountInINR = convertedAmountInINR;

        this.currencyConversionFrom = currencyConversionFrom;
        this.initalAmountSubmitted = nonConvertedmount;
    }

    public int getConvertedAmountInINR() {
        return convertedAmountInINR;
    }

    public String getCurrencyConversionFrom() {
        return currencyConversionFrom;
    }

    public int getInitalAmountSubmitted() {
        return initalAmountSubmitted;
    }
}
