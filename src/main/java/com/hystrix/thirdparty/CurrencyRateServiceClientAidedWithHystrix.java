package com.hystrix.thirdparty;

import com.hystrix.hystrixCommands.GetCurrencyRateCommand;
import com.hystrix.requestResponse.ConversionRateResponse;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class CurrencyRateServiceClientAidedWithHystrix implements CurrencyRateServiceClient {

    private WebTarget target;

    @Inject
    public CurrencyRateServiceClientAidedWithHystrix(Client httpClient, @Named("slowServerUrl") String slowServerUrl){
        target = httpClient.target(slowServerUrl);
    }

    public ConversionRateResponse getCurrentCurrencyConversionRate(String currency){
        return new GetCurrencyRateCommand(target.path("conversionRate/"+currency)).execute();
    }
}
