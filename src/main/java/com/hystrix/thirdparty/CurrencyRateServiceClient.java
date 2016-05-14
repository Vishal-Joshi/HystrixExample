package com.hystrix.thirdparty;

import com.hystrix.requestResponse.ConversionRateResponse;

public interface CurrencyRateServiceClient {
    ConversionRateResponse getCurrentCurrencyConversionRate(String currency);
}
