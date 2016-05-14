package com.hystrix.hystrixCommands;

import com.hystrix.requestResponse.ConversionRateResponse;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import javax.ws.rs.client.WebTarget;

public class GetCurrencyRateCommand extends HystrixCommand<ConversionRateResponse> {
    private WebTarget currencyServiceTarget;

    public GetCurrencyRateCommand(WebTarget currencyServiceTarget) {
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetCurrencyRateCommand"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        .withExecutionTimeoutInMilliseconds(4000)));
        this.currencyServiceTarget = currencyServiceTarget;
    }

    @Override
    protected ConversionRateResponse run() throws Exception {
        return currencyServiceTarget.request().get(ConversionRateResponse.class);
    }
}
