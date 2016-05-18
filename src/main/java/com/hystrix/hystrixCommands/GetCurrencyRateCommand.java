package com.hystrix.hystrixCommands;

import com.hystrix.requestResponse.ConversionRateResponse;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import javax.ws.rs.client.WebTarget;

public class GetCurrencyRateCommand extends HystrixCommand<ConversionRateResponse> {
    private WebTarget currencyServiceTarget;

    public GetCurrencyRateCommand(WebTarget currencyServiceTarget) {
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("Group"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetCurrencyRateCommand")));
        this.currencyServiceTarget = currencyServiceTarget;
    }

    @Override
    protected ConversionRateResponse run() throws Exception {
        return currencyServiceTarget.request().get(ConversionRateResponse.class);
    }
}
