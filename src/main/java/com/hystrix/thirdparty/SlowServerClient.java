package com.hystrix.thirdparty;

import com.hystrix.requestResponse.ConversionRateResponse;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

@Service
public class SlowServerClient {

    private WebTarget target;

    @Inject
    public SlowServerClient(Client httpClient, @Named("slowServerUrl") String slowServerUrl){
        target = httpClient.target(slowServerUrl);
    }

    public ConversionRateResponse getCurrentCurrencyConversionRate(String currency){
        return target.path("conversionRate/"+currency).request().get(ConversionRateResponse.class);
    }
}
